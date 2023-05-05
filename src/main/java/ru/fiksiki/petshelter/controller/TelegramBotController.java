package ru.fiksiki.petshelter.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.CommandContainer;
import ru.fiksiki.petshelter.step.StepsContainer;



@Controller
@Component
public class TelegramBotController extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";
    @Value("${telegram.bot.name}") private String botName;

    @Value("${telegram.bot.token}") private String botToken;

    private final CommandContainer commandContainer;
    private final StepsContainer stepsContainer;

    public TelegramBotController(
            @Lazy CommandContainer commandContainer,
            @Lazy StepsContainer stepsContainer)
    {
        this.commandContainer = commandContainer;
        this.stepsContainer = stepsContainer;
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
        if (update.hasMessage() && !update.getMessage().hasPhoto()) {          // поиск наличия сообщений
            message = update.getMessage().getText();
        }
        if (update.hasCallbackQuery()) {        // если есть клавиатура или данные с нее
            message = update.getCallbackQuery().getData();
        }
        if (stepsContainer.isContains(update)) {     // если это продолжение многостадийной команды
            stepsContainer.getStep(update).doStep(update);
        }
        if (message.startsWith(COMMAND_PREFIX)) {   // если это обычная команда
            commandContainer.retrieveCommand(message).execute(update);
        } else {
            System.out.println(message);
        }
    }


}
