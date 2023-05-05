package ru.fiksiki.petshelter.step;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.model.Report;
import ru.fiksiki.petshelter.services.SendMessageService;

import java.nio.file.Path;

@Log4j
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Service
public class SendReportStep extends Step {

    private final static String START_TEXT = "Пожалуйста, опишите одним сообщением сегодняшний рацион питомца: ";
    private final static String GET_DIET = "Пожалуйста, опишите одним сообщением самочувствие питомца: ";
    private final static String GET_BEHAVIOR =
            "Пожалуйста, опишите одним сообщением изменение в его поведении или " + "приобретенные привычки: ";
    private final static String GET_PHOTO = "Пожалуйста, отправьте фотографию вашего питомца: ";
    private final Report report;

    public SendReportStep(
            StepsContainer container, SendMessageService sendBotMessageService)
    {
        super(container, sendBotMessageService);
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
                getPhoto(update);
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

    private void getPhoto(Update update) {
        long id = getId(update);
        setStep(StepName.FIVE);
        Path doc = report.doReportFile("Igor");
        Path photo = getSendMessageService().savePhotoToReport(update,"Igor");
        report.insertPhoto(photo,doc);
        getSendMessageService().sendDocument(id, new InputFile(doc.toFile()));
    }


}
