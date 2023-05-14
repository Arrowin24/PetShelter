package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.step.CreateUserCatStep;

/**
 * Command for registration new UserCat
 */
@Component
public class CreateUserCatCommand extends Command {
    /**
     * Constructs a new CreateUserCatCommand instance with the specified CreateUserCatStep
     *
     * @param createUserCatStep  creates a new cat breeder
     */

    private final CreateUserCatStep createUserCatStep;

    public CreateUserCatCommand(CreateUserCatStep createUserCatStep) {
        super(CommandName.CREATE_USER_CAT);
        this.createUserCatStep = createUserCatStep;
    }

    /**
     * Executes the СreateUserCatCommand with the specified Update.
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        createUserCatStep.startStep(update);
    }
}
