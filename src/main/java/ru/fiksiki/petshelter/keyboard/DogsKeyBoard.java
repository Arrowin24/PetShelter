package ru.fiksiki.petshelter.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.fiksiki.petshelter.command.CommandName;

import java.util.ArrayList;
import java.util.List;

public class DogsKeyBoard implements KeyBoard{
    @Override
    public InlineKeyboardMarkup getKeyBoard() {
        InlineKeyboardButton button1 = createButton("Узнать информацию о приюте", CommandName.INFO_SHELTER);
        InlineKeyboardButton button2 = createButton("Как взять животное из приюта", CommandName.GET_PET_IS_SHELTER);
        InlineKeyboardButton button3 = createButton("Прислать отчет о питомце", CommandName.GET_REPORT_IS_PET);
        InlineKeyboardButton button4 = createButton("Позвать волонтера", CommandName.GET_VOLUNTEERS);
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(createButtonsLine(button1));
        keyboard.add(createButtonsLine(button2));
        keyboard.add(createButtonsLine(button3));
        keyboard.add(createButtonsLine(button4));
        return  new InlineKeyboardMarkup(keyboard);
    }
}
