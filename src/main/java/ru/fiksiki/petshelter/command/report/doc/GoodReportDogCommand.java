package ru.fiksiki.petshelter.command.report.doc;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.keyboard.DogsKeyBoard;
import ru.fiksiki.petshelter.services.ProbationDogService;
import ru.fiksiki.petshelter.services.SendMessageService;

import java.time.LocalDate;

import static ru.fiksiki.petshelter.controller.TelegramBotController.SPLIT;

/**
 * Represents a command executed when a user submits a good report for a dog.
 * This command sends a message to the user informing them that their report was good, and updates the timestamp of
 * their last report in the ProbationDogService.
 */
@Component
public class GoodReportDogCommand extends Command {
    private final ProbationDogService probationDogService;
    private final SendMessageService sendMessageService;

    /**
     * Constructs a GoodReportDogCommand instance with the specified ProbationDogService and SendMessageService.
     *
     * @param probationDogService the ProbationDogService used for updating the user's last report date
     * @param sendMessageService  the SendMessageService used for sending messages
     */
    public GoodReportDogCommand(ProbationDogService probationDogService, SendMessageService sendMessageService) {
        super(CommandName.GOOD_REPORT_DOG);
        this.probationDogService = probationDogService;
        this.sendMessageService = sendMessageService;
    }

    /**
     * Executes the GoodReportDogCommand with the specified Update.
     * Sends a message to the user with the ID extracted from the Update, informing them that their report was good,
     * and updates the timestamp of their last report in the ProbationDogService.
     *
     * @param update the Update object to extract the user ID from
     */
    @Override
    public void execute(Update update) {
        long userId = Long.parseLong(
                update.getCallbackQuery().getData().split(SPLIT)[1]); // extracts the user ID from the Update
        SendMessage message = new SendMessage(); // creates a new message
        message.setChatId(userId); // sets the chat ID to the user ID
        message.setText(
                "Вы отправили хороший отчет. Продолжайте в том же духе"); // sets the message to inform the user that
        // their report was good
        message.setReplyMarkup(new DogsKeyBoard().getKeyBoard()); // add main menu keyboard
        probationDogService.updateLastReportDate(userId,
                                                 LocalDate.now()); // updates the user's last report timestamp in the
        // ProbationDogService
        sendMessageService.sendMessage(message); // sends the message using SendMessageService
    }
}
