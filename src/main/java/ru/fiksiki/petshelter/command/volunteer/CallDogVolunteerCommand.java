package ru.fiksiki.petshelter.command.volunteer;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.step.talk.CallDogVolunteerStep;

/**
 * This class represents a command to make a user call a volunteer from a dog shelter
 */
@Component
public class CallDogVolunteerCommand extends Command {

    private final SendMessageService sendMessageService;

    private final CallDogVolunteerStep dogVolunteerStep;

    /**
     * Construct a new instance of the command
     *
     * @param sendMessageService service for a sending messages
     * @param dogVolunteerStep   step that displays the communication status
     */
    public CallDogVolunteerCommand(SendMessageService sendMessageService, CallDogVolunteerStep dogVolunteerStep) {
        super(CommandName.GET_DOG_VOLUNTEER);
        this.sendMessageService = sendMessageService;
        this.dogVolunteerStep = dogVolunteerStep;
    }

    /**
     * Executes the СallDogVolunteerCommand with the specified Update.
     *
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        dogVolunteerStep.startStep(update);
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
