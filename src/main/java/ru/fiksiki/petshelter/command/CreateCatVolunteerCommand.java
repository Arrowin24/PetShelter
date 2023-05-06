package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.step.CreateVolunteerCatStep;

@Component
public class CreateCatVolunteerCommand extends Command{

    private final CreateVolunteerCatStep createVolunteerCatStep;

    public CreateCatVolunteerCommand(CreateVolunteerCatStep createVolunteerCatStep) {
        super(CommandName.CREATE_CAT_VOLUNTEER);
        this.createVolunteerCatStep = createVolunteerCatStep;
    }

    @Override
    public void execute(Update update) {
        createVolunteerCatStep.startStep(update);
    }
}
