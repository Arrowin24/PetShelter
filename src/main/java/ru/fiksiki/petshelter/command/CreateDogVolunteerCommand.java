package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.step.CreateVolunteerDogStep;

@Component
public class CreateDogVolunteerCommand extends Command{

    private final CreateVolunteerDogStep createVolunteerDogStep;

    public CreateDogVolunteerCommand(CreateVolunteerDogStep createVolunteerDogStep) {
        super(CommandName.CREATE_DOG_VOLUNTEER);
        this.createVolunteerDogStep = createVolunteerDogStep;
    }

    @Override
    public void execute(Update update) {
        createVolunteerDogStep.startStep(update);
    }
}
