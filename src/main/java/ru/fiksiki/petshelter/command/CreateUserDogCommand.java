package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.step.CreateUserDogStep;

@Component
public class CreateUserDogCommand  extends  Command{

    private final CreateUserDogStep createUserDogStep;

    public CreateUserDogCommand(CreateUserDogStep createUserDogStep) {
        super(CommandName.CREATE_USER_DOG);
        this.createUserDogStep = createUserDogStep;
    }


    @Override
    public void execute(Update update) {
        createUserDogStep.startStep(update);
    }
}
