package ru.fiksiki.petshelter.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
@Controller
@Component
@Log4j
public class TelegramBotController  extends TelegramLongPollingBot {
     @Value("${telegram.bot.name}") private String botName;

     @Value("${telegram.bot.token}") private String botToken;


    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
///
    }
}
