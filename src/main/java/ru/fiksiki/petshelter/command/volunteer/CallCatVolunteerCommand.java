package ru.fiksiki.petshelter.command.volunteer;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.step.talk.CallCatVolunteerStep;

/**
 * This class represents a command to make a user call a volunteer from a cat shelter
 */
@Component
public class CallCatVolunteerCommand extends Command {

    private final SendMessageService sendMessageService;

    private final CallCatVolunteerStep catVolunteerStep;

    /**
     * Construct a new instance of the command
     * @param sendMessageService service for a sending messages
     * @param catVolunteerStep step that displays the communication status
     */

    public CallCatVolunteerCommand(SendMessageService sendMessageService, CallCatVolunteerStep catVolunteerStep) {
        super(CommandName.GET_CAT_VOLUNTEER);
        this.sendMessageService = sendMessageService;
        this.catVolunteerStep = catVolunteerStep;
    }

    /**
     * Executes the СallCatVolunteerCommand with the specified Update.
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        catVolunteerStep.startStep(update);
    }

    /**
     * @param update get info from telegram chat
     * @return the chatId from update
     */
    @Override
    public long getId(Update update) {
        return super.getId(update);
    }

    /**
     * @return the SendMessageService
     */
    public SendMessageService getSendMessageService() {
        return sendMessageService;
    }
}
