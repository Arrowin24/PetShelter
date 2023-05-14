package ru.fiksiki.petshelter.command.volunteer;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.step.talk.AnswerDogUserStep;
import ru.fiksiki.petshelter.step.talk.CallDogVolunteerStep;
import ru.fiksiki.petshelter.step.StepName;
import ru.fiksiki.petshelter.step.StepsContainer;

import static ru.fiksiki.petshelter.controller.TelegramBotController.SPLIT;
/**
 * This class represents a command that accepts a request from a user to conversation with volunteer.
 * It sets the appropriate steps and updates the container accordingly.
 */
@Component
public class AcceptDogUserQueryCommand extends Command {

    private final SendMessageService sendMessageService;

    private final StepsContainer container;

    /**
     * Constructs a new instance of the command.
     * @param sendMessageService the service used to send messages
     * @param container the container for the steps
     */
    public AcceptDogUserQueryCommand(SendMessageService sendMessageService, StepsContainer container) {
        super(CommandName.ACCEPT_DOG_USER_QUERY);
        this.sendMessageService = sendMessageService;
        this.container = container;

    }

    /**
     * Returns the container for the steps.
     * @return the container for the steps
     */
    public StepsContainer getContainer() {
        return container;
    }

    /**
     * Executes the command to update the container with the appropriate steps for accepting a user-volunteer conversation request.
     *
     * @param update the update that triggered this command
     */
    @Override
    public void execute(Update update) {
        long userId = Long.parseLong(update.getCallbackQuery().getData().split(SPLIT)[1]);
        long volunteerId = getId(update);

        CallDogVolunteerStep callDogVolunteerStep =
                (CallDogVolunteerStep) getContainer().getStepById(userId);
        callDogVolunteerStep.setStep(StepName.ONE);
        callDogVolunteerStep.setVolunteerId(getId(update));
        getContainer().putStep(userId, callDogVolunteerStep);

        AnswerDogUserStep answerDogUserStep = new AnswerDogUserStep(getContainer(), sendMessageService);

        answerDogUserStep.setUserId(userId);
        answerDogUserStep.setStep(StepName.ONE);
        getContainer().putStep(volunteerId,answerDogUserStep);
    }
}
