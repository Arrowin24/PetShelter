package ru.fiksiki.petshelter.command.volunteer;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.step.talk.CallCatVolunteerStep;

@Component
public class CallCatVolunteerCommand extends Command {

    private final SendMessageService sendMessageService;

    private final CallCatVolunteerStep catVolunteerStep;

    public CallCatVolunteerCommand(SendMessageService sendMessageService, CallCatVolunteerStep catVolunteerStep) {
        super(CommandName.GET_CAT_VOLUNTEER);
        this.sendMessageService = sendMessageService;
        this.catVolunteerStep = catVolunteerStep;
    }

    @Override
    public void execute(Update update) {
        catVolunteerStep.startStep(update);
    }

    @Override
    public long getId(Update update) {
        return super.getId(update);
    }

    public SendMessageService getSendMessageService() {
        return sendMessageService;
    }
}
