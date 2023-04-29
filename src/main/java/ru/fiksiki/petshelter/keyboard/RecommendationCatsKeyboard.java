package ru.fiksiki.petshelter.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;

import java.util.ArrayList;
import java.util.List;

public class RecommendationCatsKeyboard implements KeyBoard{
    @Override
    public InlineKeyboardMarkup getKeyBoard() {
        InlineKeyboardButton button1 = createButton("Правила знакомства с кошкой", CommandName.CATS_RULES);
        InlineKeyboardButton button2 = createButton("Документы необходимые для взятия кошки из приюта", CommandName.LIST_DOCUMENTATIONS_CATS);
        InlineKeyboardButton button3 = createButton("Рекомендации по транспортировке кошки из приюта", CommandName.TRANSPORTATION_CATS);
        InlineKeyboardButton button4 = createButton("Рекомендации по обустройству дома для котенка", CommandName.HOME_IMPROVEMENT_KITTEN);
        InlineKeyboardButton button5 = createButton("Рекомендации по обустройству дома для взрослой кошки", CommandName.HOME_IMPROVEMENT_CATS);
        InlineKeyboardButton button6 = createButton("Рекомендации по обустройству дома для кошки с ограниченными возможностями", CommandName.HOME_IMPROVEMENT_DISABLED_CATS);
        InlineKeyboardButton button7 = createButton("Причины отказа от взятия кошки из приюта", CommandName.REASONS_FOR_REFUSAL_CATS);
        InlineKeyboardButton button8 = createButton("Вернуться в меню", CommandName.RECOMMENDATIONS_CATS);
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(createButtonsLine(button1));
        keyboard.add(createButtonsLine(button2));
        keyboard.add(createButtonsLine(button3));
        keyboard.add(createButtonsLine(button4));
        keyboard.add(createButtonsLine(button5));
        keyboard.add(createButtonsLine(button6));
        keyboard.add(createButtonsLine(button7));
        keyboard.add(createButtonsLine(button8));
        return new InlineKeyboardMarkup(keyboard);
    }
}
