package ru.fiksiki.petshelter.command.report;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.services.SendMessageService;


import static ru.fiksiki.petshelter.controller.TelegramBotController.SPLIT;

/**
 * Represents a command executed when a user submits a bad report for a dog.
 * This command sends a message to the user informing them that their report is incomplete and needs to be filled out
 * more thoroughly.
 */
@Component
public class BadReportDogCommand extends Command {
    private final String TEXT = "Дорогой усыновитель, мы заметили, что ты заполняешь отчет не так подробно, как " +
            "необходимо. Пожалуйста, подойди ответственнее к этому занятию. В противном случае волонтеры приюта " +
            "будут" + " обязаны самолично проверять условия содержания животного";
    private final SendMessageService sendMessageService;

    /**
     * Constructs a BadReportDogCommand instance with the specified SendMessageService.
     *
     * @param sendMessageService the SendMessageService to use for sending messages
     */
    public BadReportDogCommand(SendMessageService sendMessageService) {
        super(CommandName.BAD_REPORT_DOG);
        this.sendMessageService = sendMessageService;
    }

    /**
     * Executes the BadReportDogCommand with the specified Update.
     * Sends a message to the user with the ID extracted from the Update, informing them that their report needs to
     * be more thorough.
     *
     * @param update the Update object to extract the user ID from
     */
    @Override
    public void execute(Update update) {
        long userId = Long.parseLong(
                update.getCallbackQuery().getData().split(SPLIT)[1]); // extracts the user ID from the Update
        SendMessage message = new SendMessage(); // creates a new message
        message.setChatId(userId); // sets the chat ID to the user ID
        message.setText(TEXT); // sets the message to inform the user to fill out their report more thoroughly
        sendMessageService.sendMessage(message); // sends the message using the SendMessageService
    }
}
