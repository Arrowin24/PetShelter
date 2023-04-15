package ru.fiksiki.petshelter.services;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface SendMessageService {
    void sendMessage(SendMessage message);
}
