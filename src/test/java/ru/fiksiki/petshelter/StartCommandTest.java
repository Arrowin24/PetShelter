package ru.fiksiki.petshelter;

import org.junit.jupiter.api.DisplayName;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.StartCommand;
import ru.fiksiki.petshelter.keyboard.KeyBoard;
import ru.fiksiki.petshelter.keyboard.StartKeyBoard;

import static ru.fiksiki.petshelter.command.CommandName.START;
import static ru.fiksiki.petshelter.command.StartCommand.START_MESSAGE;

@DisplayName("Unit-level testing for StartCommand")
public class StartCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }

    @Override
    InlineKeyboardMarkup getKeyboard() {
        return  new StartKeyBoard().getKeyBoard();
    }


}
