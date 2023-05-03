package ru.fiksiki.petshelter.services;

import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;

/**
 * interface for something....
 */
public interface SendMessageService {
    void sendMessage(SendMessage message);

       void sendDocument(long chatId, InputFile document);
}
