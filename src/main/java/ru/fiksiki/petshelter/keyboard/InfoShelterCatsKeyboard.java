package ru.fiksiki.petshelter.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.fiksiki.petshelter.command.CommandName;

import java.util.ArrayList;
import java.util.List;

public class InfoShelterCatsKeyboard implements KeyBoard{

    @Override
    public InlineKeyboardMarkup getKeyBoard() {
        InlineKeyboardButton button1 = createButton("Узнать расписание работы приюта для кошек и адрес", CommandName.INFO_WORK_SCHEDULE_CATS);
        InlineKeyboardButton button2 = createButton("Данные охраны для оформления пропуска на машину", CommandName.CONTACT_SECURITY_CATS);
        InlineKeyboardButton button3 = createButton("Рекомендации по технике безопасности", CommandName.RECOMMENDATIONS_SAFETY_CATS);
        InlineKeyboardButton button4 = createButton("Вернуться в меню", CommandName.INFO_DOGS);
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(createButtonsLine(button1));
        keyboard.add(createButtonsLine(button2));
        keyboard.add(createButtonsLine(button3));
        keyboard.add(createButtonsLine(button4));
        return new InlineKeyboardMarkup(keyboard);
    }
}
