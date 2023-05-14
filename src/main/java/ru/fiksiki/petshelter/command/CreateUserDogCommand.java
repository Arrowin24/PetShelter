package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.step.CreateUserDogStep;

/**
 * Command for registration new UserDog
 */
@Component
public class CreateUserDogCommand extends Command {
    /**
     * Constructs a new CreateUserDogCommand instance with the specified CreateUserDogStep
     *
     * @param createUserDogStep  creates a new dog breeder
     */
    private final CreateUserDogStep createUserDogStep;

    public CreateUserDogCommand(CreateUserDogStep createUserDogStep) {
        super(CommandName.CREATE_USER_DOG);
        this.createUserDogStep = createUserDogStep;
    }

    /**
     * Executes the СreateUserDogCommand with the specified Update.
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        createUserDogStep.startStep(update);
    }
}
