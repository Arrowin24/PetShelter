package ru.fiksiki.petshelter.services.impl;


import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.fiksiki.petshelter.controller.TelegramBotController;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Service for something....
 */
@Log4j
@Service
public class SendMessageServiceImpl implements SendMessageService {
    private final TelegramBotController telegramBot;

    @Autowired
    public SendMessageServiceImpl(@Lazy TelegramBotController telegramBot) {
        this.telegramBot = telegramBot;
    }

    /**
     * Methode to send message
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

}