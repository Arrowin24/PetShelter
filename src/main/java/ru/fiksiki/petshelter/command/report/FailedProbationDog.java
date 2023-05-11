package ru.fiksiki.petshelter.command.report;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.services.SendMessageService;


import static ru.fiksiki.petshelter.controller.TelegramBotController.SPLIT;

/**
 * Represents a command executed when a user fails their probation period.
 * This command sends a message to the user informing them of their status.
 */
@Component
public class FailedProbationDog extends Command {
    private final SendMessageService sendMessageService;

    /**
     * Constructs a new FailedProbationDog instance with the specified SendMessageService.
     * @param sendMessageService the SendMessageService to use for sending messages
     */
    public FailedProbationDog(SendMessageService sendMessageService) {
        super(CommandName.FAILED_PROBATION_DOG);
        this.sendMessageService = sendMessageService;
    }

    /**
     * Executes the FailedProbationDog command with the specified Update.
     * Sends a message to the user with the specified chat ID, informing them that they
     * have failed their probation period and that a volunteer will contact them soon.
     * @param update the Update object to extract the user ID from
     */
    @Override
    public void execute(Update update) {
        long userId = Long.parseLong(update.getCallbackQuery().getData().split(SPLIT)[1]); // extracts the user ID from the Update
        SendMessage message = new SendMessage(); // creates a new message
        message.setChatId(userId); // sets the chat ID to the user ID
        message.setText(
                "К несчастью вы не прошли испытательный срок. Скоро с вами свяжется волонтер и расскажет вам " +
                        "дальнейшие шаги");  // sets the message to inform the users of their failed probation
        sendMessageService.sendMessage(message); // sends the message using the SendMessageService
    }
}
