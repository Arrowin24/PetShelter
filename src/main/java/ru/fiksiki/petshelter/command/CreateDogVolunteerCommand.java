package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.step.CreateVolunteerDogStep;

/**
 * A command that handles creating a new dog volunteer profile.
 */
@Component
public class CreateDogVolunteerCommand extends Command{

    private final CreateVolunteerDogStep createVolunteerDogStep;

    /**
     * Constructs a new instance of the command.
     *
     * @param createVolunteerDogStep the step for creating a new dog volunteer profile
     */
    public CreateDogVolunteerCommand(CreateVolunteerDogStep createVolunteerDogStep) {
        super(CommandName.CREATE_DOG_VOLUNTEER);
        this.createVolunteerDogStep = createVolunteerDogStep;
    }

    /**
     * Executes the command to start the step for creating a new dog volunteer profile.
     *
     * @param update the update that triggered this command
     */
    @Override
    public void execute(Update update) {
        createVolunteerDogStep.startStep(update);
    }
}
