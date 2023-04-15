package ru.fiksiki.petshelter.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.CommandContainer;

@Controller
@Component
public class TelegramBotController  extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";
     @Value("${telegram.bot.name}") private String botName;

     @Value("${telegram.bot.token}") private String botToken;

    private final CommandContainer commandContainer;

    public TelegramBotController(CommandContainer commandContainer) {
        this.commandContainer = commandContainer;
    }

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
        String message = "Какая-то ошибка";
        if (update.hasMessage()) {          // поиск наличия сообщений
            message = update.getMessage().getText();
        }
        if (update.hasCallbackQuery()) {        // если есть клавиатура или данные с нее
            message = update.getCallbackQuery().getData();
        }
        if (message.startsWith(COMMAND_PREFIX)) {   // если это обычная команда
            commandContainer.retrieveCommand(message).execute(update);
        }
        else {
            System.out.println(message);
        }
    }
}
