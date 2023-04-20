package ru.fiksiki.petshelter.services;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

/**
 * interface for something....
 */
public interface SendMessageService {
    void sendMessage(SendMessage message);
}
