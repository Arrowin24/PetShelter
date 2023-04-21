package ru.fiksiki.petshelter.model.imp;


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

        }
    }

}
