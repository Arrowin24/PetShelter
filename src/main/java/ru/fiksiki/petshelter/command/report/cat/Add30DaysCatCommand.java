package ru.fiksiki.petshelter.command.report.cat;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.keyboard.CatsKeyBoard;
import ru.fiksiki.petshelter.model.ProbationCat;
import ru.fiksiki.petshelter.model.ProbationDog;
import ru.fiksiki.petshelter.services.ProbationCatService;
import ru.fiksiki.petshelter.services.ProbationDogService;
import ru.fiksiki.petshelter.services.SendMessageService;

import static ru.fiksiki.petshelter.controller.TelegramBotController.SPLIT;

/**
 * Represents a command executed when 30 days are added to a user's probation period.
 * This command updates the user's probation period by adding 14 days to their remaining days.
 */
@Component
public class Add30DaysCatCommand extends Command {
    private final ProbationCatService probationCatService;
    private final SendMessageService sendMessageService;

    /**
     * Constructs a new Add14DaysDogCommand instance with the specified ProbationDogService and SendMessageService.
     *
     * @param probationDogService the probationCatService to use for interacting with the database
     * @param sendMessageService  the SendMessageService to use for sending messages
     */
    public Add30DaysCatCommand(ProbationCatService probationDogService, SendMessageService sendMessageService)
    {
        super(CommandName.ADD_30_DAYS_CAT);
        this.probationCatService = probationDogService;
        this.sendMessageService = sendMessageService;
    }

    /**
     * Executes the Add14DaysCatCommand with the specified Update.
     * Adds 14 days to the user's remaining probation days and updates the record in the database.
     *
     * @param update the Update object to extract the user ID from
     */
    @Override
    public void execute(Update update) {
        long userId = Long.parseLong(
                update.getCallbackQuery().getData().split(SPLIT)[1]);  // extracts the user ID from the Update
        SendMessage message = new SendMessage();
        message.setChatId(userId);
        message.setText("На данный момент мы решили увеличить количество испытательного срока на 30 дней");
        ProbationCat probationCat = probationCatService.read(userId); // reads the ProbationCat record for the user
        probationCat.setDayLeft(probationCat.getDayLeft() + 30); // increases the number of remaining days by 30
        probationCatService.updateDayLeft(probationCat); // updates the record in the database
        message.setReplyMarkup(new CatsKeyBoard().getKeyBoard()); // add main menu keyboard
        sendMessageService.sendMessage(message);
    }
}
