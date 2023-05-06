package ru.fiksiki.petshelter.command.volunteer;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.step.*;
import ru.fiksiki.petshelter.step.talk.AnswerCatUserStep;
import ru.fiksiki.petshelter.step.talk.CallCatVolunteerStep;

import static ru.fiksiki.petshelter.controller.TelegramBotController.SPLIT;

@Component
public class AcceptCatUserQueryCommand extends Command {

    private final SendMessageService sendMessageService;

    private final StepsContainer container;


    public AcceptCatUserQueryCommand(SendMessageService sendMessageService, StepsContainer container) {
        super(CommandName.ACCEPT_CAT_USER_QUERY);
        this.sendMessageService = sendMessageService;
        this.container = container;

    }

    public StepsContainer getContainer() {
        return container;
    }

    @Override
    public void execute(Update update) {
        long userId = Long.parseLong(update.getCallbackQuery().getData().split(SPLIT)[1]);
        long volunteerId = getId(update);

        CallCatVolunteerStep callCatVolunteerStep =
                (CallCatVolunteerStep) getContainer().getStepById(userId);
        callCatVolunteerStep.setStep(StepName.ONE);
        callCatVolunteerStep.setVolunteerId(getId(update));
        getContainer().putStep(userId, callCatVolunteerStep);

        AnswerCatUserStep answerCatUserStep = new AnswerCatUserStep(getContainer(), sendMessageService);

        answerCatUserStep.setUserId(userId);
        answerCatUserStep.setStep(StepName.ONE);
        getContainer().putStep(volunteerId,answerCatUserStep);


    }
}
