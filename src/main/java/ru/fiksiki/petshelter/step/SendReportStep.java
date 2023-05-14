package ru.fiksiki.petshelter.step;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.answer.ReportDogAnswerKeyBoard;
import ru.fiksiki.petshelter.model.ProbationDog;
import ru.fiksiki.petshelter.model.Report;
import ru.fiksiki.petshelter.model.UserDog;
import ru.fiksiki.petshelter.services.ProbationDogService;
import ru.fiksiki.petshelter.services.SendMessageService;

import java.nio.file.Path;

@Log4j
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Service
public class SendReportStep extends Step {
    private final Report report;

    private final ProbationDogService probationDogService;
    private final static String START_TEXT = "Пожалуйста, опишите одним сообщением сегодняшний рацион питомца: ";
    private final static String GET_DIET = "Пожалуйста, опишите одним сообщением самочувствие питомца: ";
    private final static String GET_BEHAVIOR =
            "Пожалуйста, опишите одним сообщением изменение в его поведении или " + "приобретенные привычки: ";
    private final static String GET_PHOTO = "Пожалуйста, отправьте фотографию вашего питомца: ";

    public SendReportStep(
            StepsContainer container, SendMessageService sendBotMessageService, ProbationDogService probationDogService)
    {
        super(container, sendBotMessageService);
        this.probationDogService = probationDogService;
        report = new Report();
    }

    @Override
    public void startStep(Update update) {
        long id = getId(update);
        this.setStep(StepName.ONE);
        getContainer().putStep(id, this);
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
                getDiet(update);
                break;
            case TWO:
                getHealth(update);
                break;
            case THREE:
                getBehavior(update);
                break;
            case FOUR:
                getPhoto();
                sendReport(update);
                break;
            default:
                //    errorStep(update);
                log.debug("Произошла ошибка регистрации. У пользователя с id=" + update.getMessage()
                                                                                       .getChatId() + " последнее " + "сообщение: " + update
                        .getMessage().getText());
                break;
        }
    }

    private void getDiet(Update update) {
        long id = getId(update);
        setStep(StepName.TWO);
        String ration = update.getMessage().getText();
        report.setRation(ration);
        SendMessage message = new SendMessage();
        message.setChatId(id);
        message.setText(GET_DIET);
        getSendMessageService().sendMessage(message);
    }

    private void getHealth(Update update) {
        long id = getId(update);
        setStep(StepName.THREE);
        String health = update.getMessage().getText();
        report.setHealth(health);
        SendMessage message = new SendMessage();
        message.setChatId(id);
        message.setText(GET_BEHAVIOR);
        getSendMessageService().sendMessage(message);
    }

    private void getBehavior(Update update) {
        long id = getId(update);
        setStep(StepName.FOUR);
        String behavior = update.getMessage().getText();
        report.setBehavior(behavior);
        SendMessage message = new SendMessage();
        message.setChatId(id);
        message.setText(GET_PHOTO);
        getSendMessageService().sendMessage(message);
    }

    private void getPhoto() {
        setStep(StepName.FIVE);
    }

    private void sendReport(Update update) {
        long id = getId(update);
        if (probationDogService.isProbationDog(update.getMessage().getChatId())) {
            UserDog user = probationDogService.getUserDog(id);
            ProbationDog probationDog = probationDogService.read(id);
            Path doc = report.doReportFile(user.getName());
            Path photo = getSendMessageService().savePhotoToReport(update, user.getName());
            report.insertPhoto(photo, doc);
            getSendMessageService().sendDocument(probationDog.getVolunteerId(), new InputFile(doc.toFile()));
            SendMessage message = new SendMessage();
            message.setChatId(probationDog.getVolunteerId());
            message.setText("Выберете решение по отчету");
            message.setReplyMarkup(new ReportDogAnswerKeyBoard().getKeyBoard(id));
            getSendMessageService().sendMessage(message);
        }
        finishStep(id);
    }


    private void finishStep(Long id) {
        getContainer().deleteStep(id);
    }
}
