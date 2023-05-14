package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.step.CreateVolunteerCatStep;

/**
 *  A command that handles creating a new cat volunteer profile.
 */
@Component
public class CreateCatVolunteerCommand extends Command{

    /**
     * Constructs a new CreateCatVolunteerCommand instance with the specified CreateVolunteerCatStep
     *
     * @param createVolunteerCatStep the step for creating a new cat volunteer profile
     */
    private final CreateVolunteerCatStep createVolunteerCatStep;

    public CreateCatVolunteerCommand(CreateVolunteerCatStep createVolunteerCatStep) {
        super(CommandName.CREATE_CAT_VOLUNTEER);
        this.createVolunteerCatStep = createVolunteerCatStep;
    }

    /**
     *
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        createVolunteerCatStep.startStep(update);
    }
}
