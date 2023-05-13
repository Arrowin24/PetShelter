package ru.fiksiki.petshelter.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.fiksiki.petshelter.command.CommandName;

import java.util.ArrayList;
import java.util.List;

public class DogsKeyBoard implements KeyBoard{
    @Override
    public InlineKeyboardMarkup getKeyBoard() {
        InlineKeyboardButton button1 = createButton("Узнать информацию о приюте", CommandName.INFO_DOGS);
        InlineKeyboardButton button2 = createButton("Рекомендации для будущих хозяев собаки", CommandName.RECOMMENDATIONS_DOGS);
        InlineKeyboardButton button3 = createButton("Прислать отчет о питомце", CommandName.REPORT_DOG);
        InlineKeyboardButton button4 = createButton("Позвать волонтера", CommandName.GET_DOG_VOLUNTEER);
        InlineKeyboardButton button5 = createButton("Вернуться в меню", CommandName.START);
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(createButtonsLine(button1));
        keyboard.add(createButtonsLine(button2));
        keyboard.add(createButtonsLine(button3));
        keyboard.add(createButtonsLine(button4));
        keyboard.add(createButtonsLine(button5));
        return  new InlineKeyboardMarkup(keyboard);
    }
}
