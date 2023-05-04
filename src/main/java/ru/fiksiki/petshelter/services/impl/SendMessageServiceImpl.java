package ru.fiksiki.petshelter.services.impl;


import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.fiksiki.petshelter.controller.TelegramBotController;
import ru.fiksiki.petshelter.services.SendMessageService;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;

/**
 * Service for something....
 */
@Log4j
@Service
public class SendMessageServiceImpl implements SendMessageService {
    private final TelegramBotController telegramBot;

    @Autowired
    public SendMessageServiceImpl(
            TelegramBotController telegramBot)
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
            String id = String.valueOf(chatId);
            SendDocument sendDocumentRequest = new SendDocument(id, document);
            sendDocumentRequest.setCaption("Caption of file");
            System.out.println(sendDocumentRequest);
            // execute the request
            telegramBot.execute(sendDocumentRequest);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Path savePhotoToReport(Update update, String adopterName) {
        List<PhotoSize> photos = update.getMessage().getPhoto();
        PhotoSize photo = photos.stream().min((p1, p2) -> Integer.compare(p2.getFileSize(), p1.getFileSize()))
                                .orElse(null);

        if (photo != null) {
            try {
                // Get file path of photo
                GetFile getFileMethod = new GetFile();
                getFileMethod.setFileId(photo.getFileId());
                org.telegram.telegrambots.meta.api.objects.File file = telegramBot.execute(getFileMethod);
                String filePath = file.getFilePath();

                // Construct URL for photo
                String baseUrl = "https://api.telegram.org/file/bot" + telegramBot.getBotToken() + "/";
                URL url = new URL(baseUrl + filePath);

                // Download photo from URL
                InputStream is = url.openStream();
                FileOutputStream fos = new FileOutputStream("C:\\" + "photo" + adopterName + ".png");
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                fos.close();
                is.close();

            } catch (Exception e) {
                // Handle errors
                e.printStackTrace();
            }
        }
        return Path.of("C:\\" + "photo" + adopterName + ".jpg");
    }


}
