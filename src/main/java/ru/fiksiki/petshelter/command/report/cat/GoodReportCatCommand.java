package ru.fiksiki.petshelter.command.report.cat;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.keyboard.DogsKeyBoard;
import ru.fiksiki.petshelter.services.ProbationCatService;
import ru.fiksiki.petshelter.services.ProbationDogService;
import ru.fiksiki.petshelter.services.SendMessageService;

import java.time.LocalDate;

import static ru.fiksiki.petshelter.controller.TelegramBotController.SPLIT;

/**
 * Represents a command executed when a user submits a good report for a cat.
 * This command sends a message to the user informing them that their report was good, and updates the timestamp of
 * their last report in the ProbationCatService.
 */
@Component
public class GoodReportCatCommand extends Command {
    private final ProbationCatService probationCatService;
    private final SendMessageService sendMessageService;

    /**
     * Constructs a GoodReportCatCommand instance with the specified ProbationCatService and SendMessageService.
     *
     * @param probationCatService used for updating the user's last report date
     * @param sendMessageService  the SendMessageService used for sending messages
     */
    public GoodReportCatCommand(
            ProbationCatService probationCatService, SendMessageService sendMessageService)
    {
        super(CommandName.GOOD_REPORT_DOG);
        this.probationCatService = probationCatService;

        this.sendMessageService = sendMessageService;
    }

    /**
     * Executes the GoodReportDogCommand with the specified Update.
     * Sends a message to the user with the ID extracted from the Update, informing them that their report was good,
     * and updates the timestamp of their last report in the ProbationCatService.
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
        probationCatService.updateLastReportDate(userId,
                                                 LocalDate.now()); // updates the user's last report timestamp in the
        // ProbationCatService
        sendMessageService.sendMessage(message); // sends the message using SendMessageService
    }
}
