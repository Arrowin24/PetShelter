package ru.fiksiki.petshelter;

import org.junit.jupiter.api.DisplayName;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.fiksiki.petshelter.command.CatsCommand;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.keyboard.CatsKeyBoard;

import static ru.fiksiki.petshelter.command.CatsCommand.CATS_MESSAGE;
import static ru.fiksiki.petshelter.command.CommandName.CATS;

@DisplayName("Test for CatsCommand")
public class CatsCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return CATS.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return CATS_MESSAGE ;
    }

    @Override
    Command getCommand() {
        return new CatsCommand(sendBotMessageService);
    }

    @Override
    InlineKeyboardMarkup getKeyboard() {
        return new CatsKeyBoard().getKeyBoard();
    }
}
