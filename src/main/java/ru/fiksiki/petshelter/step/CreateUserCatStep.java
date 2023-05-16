package ru.fiksiki.petshelter.step;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.StartKeyBoard;
import ru.fiksiki.petshelter.model.UserCat;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.services.UserCatService;


@Log4j
@Service
public class CreateUserCatStep extends Step {

    private final UserCat userCat;

    private final UserCatService userCatService;

    private final static String START_TEXT = "Введите имя: ";
    private final static String ADD_NAME_TEXT = "Введите контактный телефон: ";
    private final static String ADD_PHONE_TEXT = "Введите контактную почту: ";
    private final static String ADD_MAIL_TEXT = "Данные приняты!";
    private final static String FINISH_TEXT = "Вы зарегистрировались как потенциальный хозяин кошки/кота!";
    private final static String ERROR_TEXT = "Произошла непредвиденная ошибка! Попробуйте еще раз зарегистрироваться";


    public CreateUserCatStep(StepsContainer container, SendMessageService sendBotMessageService, UserCatService userCatService) {
        super(container, sendBotMessageService);
        this.userCat = new UserCat();
        this.userCatService = userCatService;
    }

    public UserCat getUserCat() {
        return userCat;
    }

    @Override
    public void startStep(Update update) {
        long id = getId(update);
        CreateUserCatStep createUserCatStep = new CreateUserCatStep(getContainer(),
                getSendMessageService(),
                userCatService);
        createUserCatStep.setStep(StepName.ONE);
        createUserCatStep.getUserCat().setId(id);
        getContainer().putStep(id, createUserCatStep);
        SendMessage message = new SendMessage();
        message.setChatId(id);
        message.setText(START_TEXT);
        getSendMessageService().sendMessage(message);
    }

    @Override
    public void doStep(Update update) {
        Step currentStep = getContainer().getStep(update);
        switch (currentStep.getStep()) {
            case ONE:
                addNameStep(update);
                break;
            case TWO:
                addPhoneStep(update);
                break;
            case THREE:
                addMailStep(update);
                finishStep(update);
                break;
            default:
                errorStep(update);
                log.debug("Произошла ошибка регистрации. У пользователя с id=" + update.getMessage()
                        .getChatId() + " последнее " + "сообщение: " + update
                        .getMessage().getText());
                break;

        }
    }

    private void addNameStep(Update update) {
        long id = getId(update);
        String name = update.getMessage().getText();
        userCat.setName(name);
        setStep(StepName.TWO);
        SendMessage message = new SendMessage();
        message.setChatId(id);
        message.setText(ADD_NAME_TEXT);
        getSendMessageService().sendMessage(message);
    }

    private void addPhoneStep(Update update) {
        long id = getId(update);
        String phone = update.getMessage().getText();
        userCat.setPhone(phone);
        setStep(StepName.THREE);
        SendMessage message = new SendMessage();
        message.setChatId(id);
        message.setText(ADD_PHONE_TEXT);
        getSendMessageService().sendMessage(message);
    }

    private void addMailStep(Update update) {
        long id = getId(update);
        String mail = update.getMessage().getText();
        userCat.setMail(mail);
        setStep(StepName.FOUR);
        SendMessage message = new SendMessage();
        message.setChatId(id);
        message.setText(ADD_MAIL_TEXT);
        getSendMessageService().sendMessage(message);
    }

    private void finishStep(Update update) {
        long id = getId(update);
        userCatService.create(userCat);
        getContainer().deleteStep(id);
        SendMessage message = new SendMessage();
        message.setChatId(id);
        message.setText(FINISH_TEXT + "\n" + userCatService.read(id).toText());
        message.setReplyMarkup(new StartKeyBoard().getKeyBoard());
        getSendMessageService().sendMessage(message);
    }

    private void errorStep(Update update) {
        long id = getId(update);
        getContainer().deleteStep(id);
        SendMessage message = new SendMessage();
        message.setChatId(id);
        message.setText(ERROR_TEXT);
        message.setReplyMarkup(new StartKeyBoard().getKeyBoard());
        getSendMessageService().sendMessage(message);
    }


}
