package ru.fiksiki.petshelter;

import org.junit.jupiter.api.DisplayName;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.HelpCommand;
import ru.fiksiki.petshelter.keyboard.KeyBoard;

import static ru.fiksiki.petshelter.command.CommandName.HELP;
import static ru.fiksiki.petshelter.command.HelpCommand.HELP_MESSAGE;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }

    @Override
    InlineKeyboardMarkup getKeyboard() {
        return null;
    }
}
