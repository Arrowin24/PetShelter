package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.step.CreateUserCatStep;
@Component
public class CreateUserCatCommand extends  Command{

    private final CreateUserCatStep createUserCatStep;

    public CreateUserCatCommand(CreateUserCatStep createUserCatStep) {
        super(CommandName.CREATE_USER_CAT);
        this.createUserCatStep = createUserCatStep;
    }

    @Override
    public void execute(Update update) {
        createUserCatStep.startStep(update);
    }
}
