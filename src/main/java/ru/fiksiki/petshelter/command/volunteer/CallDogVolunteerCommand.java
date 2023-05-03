package ru.fiksiki.petshelter.command.volunteer;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.step.talk.CallDogVolunteerStep;

@Component
public class CallDogVolunteerCommand extends Command {

    private final SendMessageService sendMessageService;

    private final CallDogVolunteerStep dogVolunteerStep;

    public CallDogVolunteerCommand(SendMessageService sendMessageService, CallDogVolunteerStep dogVolunteerStep) {
        super(CommandName.GET_DOG_VOLUNTEER);
        this.sendMessageService = sendMessageService;
        this.dogVolunteerStep = dogVolunteerStep;
    }

    @Override
    public void execute(Update update) {
        dogVolunteerStep.startStep(update);
    }

    @Override
    public long getId(Update update) {
        return super.getId(update);
    }

    public SendMessageService getSendMessageService() {
        return sendMessageService;
    }
}
