package ru.fiksiki.petshelter.command.report.doc;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.keyboard.CatsKeyBoard;
import ru.fiksiki.petshelter.keyboard.DogsKeyBoard;
import ru.fiksiki.petshelter.model.ProbationDog;
import ru.fiksiki.petshelter.services.ProbationDogService;
import ru.fiksiki.petshelter.services.SendMessageService;

import static ru.fiksiki.petshelter.controller.TelegramBotController.SPLIT;

/**
 * Represents a command executed when 14 days are added to a user's probation period.
 * This command updates the user's probation period by adding 14 days to their remaining days.
 */
@Component
public class Add14DaysDogCommand extends Command {
    private final ProbationDogService probationDogService;
    private final SendMessageService sendMessageService;

    /**
     * Constructs a new Add14DaysDogCommand instance with the specified ProbationDogService and SendMessageService.
     *
     * @param probationDogService the ProbationDogService to use for interacting with the database
     * @param sendMessageService  the SendMessageService to use for sending messages
     */
    public Add14DaysDogCommand(ProbationDogService probationDogService, SendMessageService sendMessageService)
    {
        super(CommandName.ADD_14_DAYS_DOG);
        this.probationDogService = probationDogService;
        this.sendMessageService = sendMessageService;
    }

    /**
     * Executes the Add14DaysDogCommand with the specified Update.
     * Adds 14 days to the user's remaining probation days and updates the record in the database.
     *
     * @param update the Update object to extract the user ID from
     */
    @Override
    public void execute(Update update) {
        long userId = Long.parseLong(
                update.getCallbackQuery().getData().split(SPLIT)[1]); // extracts the user ID from the Update
        SendMessage message = new SendMessage();
        message.setChatId(userId);
        message.setText("На данный момент мы решили увеличить количество испытательного срока на 14 дней");
        ProbationDog probationDog = probationDogService.read(userId); // reads the ProbationDog record for the user
        probationDog.setDayLeft(probationDog.getDayLeft() + 14); // increases the number of remaining days by 14
        probationDogService.updateDayLeft(probationDog); // updates the record in the database
        message.setReplyMarkup(new DogsKeyBoard().getKeyBoard()); // add main menu keyboard
        sendMessageService.sendMessage(message); // sends the message using the SendMessageService
    }
}
