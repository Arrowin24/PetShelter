package ru.fiksiki.petshelter.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.fiksiki.petshelter.command.CommandName;

import java.util.ArrayList;
import java.util.List;

public class StartKeyBoard  implements KeyBoard{
    @Override
    public InlineKeyboardMarkup getKeyBoard() {

        InlineKeyboardButton button2 = createButton("Приют для собак ", CommandName.DOGS);
        InlineKeyboardButton button3 = createButton("Приют для кошек ", CommandName.CATS);

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        keyboard.add(createButtonsLine(button2));
        keyboard.add(createButtonsLine(button3));
        return new InlineKeyboardMarkup(keyboard);
    }
}
