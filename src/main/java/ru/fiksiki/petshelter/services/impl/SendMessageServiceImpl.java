package ru.fiksiki.petshelter.services.impl;


import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.fiksiki.petshelter.controller.TelegramBotController;
import ru.fiksiki.petshelter.services.SendMessageService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Service for something....
 */
@Log4j
@Service
public class SendMessageServiceImpl implements SendMessageService {
    private final TelegramBotController telegramBot;

    @Autowired
    public SendMessageServiceImpl(
            @Lazy TelegramBotController telegramBot)
    {
        this.telegramBot = telegramBot;
    }

    /**
     * Methode to send message
     *
     * @param message message for telegramBot
     */
    @Override
    public void sendMessage(SendMessage message) {
        if (message == null) {
            return;
        }
        try {
            telegramBot.execute(message);
        } catch (TelegramApiException e) {
            log.debug(e.getMessage());
        }
    }

    @Override
    public void sendDocument(long chatId, InputFile document) {
        if (document == null) {
            System.out.println("Документ не записался");
            return;
        }
        try {
            SendDocument sendDocumentRequest = new SendDocument();
            sendDocumentRequest.setChatId(chatId);
            sendDocumentRequest.setDocument(document);
            sendDocumentRequest.setCaption("Caption of file");
            System.out.println(sendDocumentRequest);
            // execute the request
            telegramBot.execute(sendDocumentRequest);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
   /* private void sendPhoto(long chatId){
        try {
            InputFile file= new InputFile(new FileInputStream("C:\\photo.png"), "photo");
            SendPhoto photo = new SendPhoto();
            photo.setChatId(chatId);
            photo.setCaption("Cafdl");
            photo.setPhoto(file);

            telegramBot.execute(photo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
*/

}
