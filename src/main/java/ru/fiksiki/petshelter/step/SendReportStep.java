package ru.fiksiki.petshelter.step;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.fiksiki.petshelter.model.Report;
import ru.fiksiki.petshelter.services.SendMessageService;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Log4j
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Service
public class SendReportStep extends Step {

    private final static String START_TEXT = "Пожалуйста, опишите одним сообщением сегодняшний рацион животного : ";
    private final static String GET_PICTURE = "Пожалуйста, опишите одним сообщением: ";
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
                getReport(update);
                break;
            case TWO:
              //  addPhoneStep(update);
                break;
            case THREE:
            //    addMailStep(update);
//                break;
            default:
            //    errorStep(update);
                log.debug("Произошла ошибка регистрации. У пользователя с id=" + update.getMessage()
                                                                                       .getChatId() + " последнее " + "сообщение: " + update
                        .getMessage().getText());
                break;
        }
    }

    private void getReport(Update update) {
        long id = getId(update);
        setStep(StepName.TWO);
        String ration = update.getMessage().getText();
        report.setRation(ration);
        Path doc = report.createTempDocFile("Igor");
        InputFile file = new InputFile(doc.toFile());
        getSendMessageService().sendDocument(id,file);
    }


}
