package ru.fiksiki.petshelter.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.CommandContainer;
import ru.fiksiki.petshelter.step.StepsContainer;

/**
 * Controller for a Telegram bot.
 * This class extends the {@link TelegramLongPollingBot} class to handle updates received by the bot.
 * It processes messages and callbacks from users and executes the relevant commands.
 */
@Controller
@Component
public class TelegramBotController extends TelegramLongPollingBot {
    /**
     * The string used to split message parts.
     */
    public static String SPLIT = "&&";
    /**
     * The prefix used to denote commands.
     */
    public static String COMMAND_PREFIX = "/";
    /**
     * The name of the Telegram bot.
     */
    @Value("${telegram.bot.name}") private String botName;
    /**
     * The token used to authenticate with the Telegram API.
     */
    @Value("${telegram.bot.token}") private String botToken;

    /**
     * The container for registered commands.
     */
    private final CommandContainer commandContainer;
    /**
     * The container for multi-step commands.
     */
    private final StepsContainer stepsContainer;

    /**
     * Constructs a new instance of the Telegram bot controller with the given command and step containers.
     *
     * @param commandContainer the container for registered commands
     * @param stepsContainer   the container for multi-step commands
     */
    public TelegramBotController(
            @Lazy CommandContainer commandContainer,
            @Lazy StepsContainer stepsContainer)
    {
        this.commandContainer = commandContainer;
        this.stepsContainer = stepsContainer;
    }

    /**
     * Gets the username of the bot.
     *
     * @return the username of the bot
     */
    @Override
    public String getBotUsername() {
        return botName;
    }

    /**
     * Gets the token used to authenticate with the Telegram API.
     *
     * @return the token used to authenticate with the Telegram API
     */
    @Override
    public String getBotToken() {
        return botToken;
    }

    /**
     * Handles an update received by the bot.
     *
     * <p>
     * This method is called for each update received by the bot. It processes messages and callbacks from users
     * and executes the relevant commands.
     * </p>
     *
     * @param update the update to handle
     */
    @Override
    public void onUpdateReceived(Update update) {
        String message = "Какая-то ошибка"; // Default error message
        if (update.hasMessage() && !update.getMessage().hasPhoto()) {
            // If the update includes a message (not a photo), extract message text
            message = update.getMessage().getText();
        }
        if (update.hasCallbackQuery()) {
            // If the update includes a callback query, extract data from it
            message = update.getCallbackQuery().getData();
        }
        if (stepsContainer.isContains(update)) {
            // If this is a continuation of a multi-step command, execute the next step
            stepsContainer.getStep(update).doStep(update);
        } else if (message.startsWith(COMMAND_PREFIX)) {
            // If this is a regular command, execute it
            String command = message.split(SPLIT)[0]; // Extract command from message
            commandContainer.retrieveCommand(command).execute(update);
        }
    }
}
