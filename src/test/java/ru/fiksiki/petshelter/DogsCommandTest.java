package ru.fiksiki.petshelter;

import org.junit.jupiter.api.DisplayName;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.DogsCommand;
import ru.fiksiki.petshelter.keyboard.DogsKeyBoard;

import static ru.fiksiki.petshelter.command.DogsCommand.DOGS_MESSAGE;
import static ru.fiksiki.petshelter.command.ShelterInfoCommand.DOGS;

@DisplayName("Unit-level testing for DogCommand")
public class DogsCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return DOGS.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return DOGS_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new DogsCommand(sendBotMessageService);
    }

    @Override
    InlineKeyboardMarkup getKeyboard() {
        return new DogsKeyBoard().getKeyBoard();
    }
}
