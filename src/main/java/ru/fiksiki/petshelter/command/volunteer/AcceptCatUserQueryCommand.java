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

/**
 * This class represents a command that accepts a request from a user to adopt a cat.
 * It sets the appropriate steps and updates the container accordingly.
 */
@Component
public class AcceptCatUserQueryCommand extends Command {

    private final SendMessageService sendMessageService;

    private final StepsContainer container;

    /**
     * Constructs a new AcceptCatUserQueryCommand with the specified parameters.
     * @param sendMessageService the service used to send messages to the user
     * @param container the container that holds the steps for this command
     */
    public AcceptCatUserQueryCommand(SendMessageService sendMessageService, StepsContainer container) {
        super(CommandName.ACCEPT_CAT_USER_QUERY);
        this.sendMessageService = sendMessageService;
        this.container = container;

    }

    /**
     * Returns the steps container for this command.
     * @return the steps container for this command
     */
    public StepsContainer getContainer() {
        return container;
    }

    /**
     * Updates the container with the appropriate steps for accepting a cat adoption request.
     * @param update the update that triggered this command and got userId
     */
    @Override
    public void execute(Update update) {
        long userId = Long.parseLong(update.getCallbackQuery().getData().split(SPLIT)[1]);
        long volunteerId = getId(update);
        CallCatVolunteerStep callCatVolunteerStep = (CallCatVolunteerStep) getContainer().getStepById(userId);
        callCatVolunteerStep.setStep(StepName.ONE);
        callCatVolunteerStep.setVolunteerId(getId(update));
        getContainer().putStep(userId, callCatVolunteerStep);

        AnswerCatUserStep answerCatUserStep = new AnswerCatUserStep(getContainer(), sendMessageService);

        answerCatUserStep.setUserId(userId);
        answerCatUserStep.setStep(StepName.ONE);
        getContainer().putStep(volunteerId, answerCatUserStep);
    }
}
