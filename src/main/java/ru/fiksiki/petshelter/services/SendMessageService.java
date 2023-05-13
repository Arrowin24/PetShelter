package ru.fiksiki.petshelter.services;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;


import java.nio.file.Path;

/**
 * interface for something....
 */
public interface SendMessageService {
    void sendMessage(SendMessage message);

    void sendDocument(long chatId, InputFile document);

    Path savePhotoToReport(Update update, String adopterName);
}
