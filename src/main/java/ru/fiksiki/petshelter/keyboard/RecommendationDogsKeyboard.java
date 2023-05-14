package ru.fiksiki.petshelter.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.fiksiki.petshelter.command.CommandName;

import java.util.ArrayList;
import java.util.List;

public class RecommendationDogsKeyboard implements KeyBoard {
    @Override
    public InlineKeyboardMarkup getKeyBoard() {
        InlineKeyboardButton button1 = createButton("Правила знакомства с собакой", CommandName.DOGS_RULES);
        InlineKeyboardButton button2 = createButton("Документы необходимые для взятия собаки из приюта", CommandName.LIST_DOCUMENTATIONS_DOGS);
        InlineKeyboardButton button3 = createButton("Рекомендации по транспортировке собаки из приюта", CommandName.TRANSPORTATION_DOGS);
        InlineKeyboardButton button4 = createButton("Рекомендации по обустройству дома для щенка", CommandName.HOME_IMPROVEMENT_PUPPIES);
        InlineKeyboardButton button5 = createButton("Рекомендации по обустройству дома для взрослой собаки", CommandName.HOME_IMPROVEMENT_DOGS);
        InlineKeyboardButton button6 = createButton("Рекомендации по обустройству дома для собаки с ограниченными возможностями", CommandName.HOME_IMPROVEMENT_DISABLED_DOGS);
        InlineKeyboardButton button7 = createButton("Причины отказа от взятия собаки из приюта", CommandName.REASONS_FOR_REFUSAL_DOGS);
        InlineKeyboardButton button8 = createButton("Вернуться в меню", CommandName.RECOMMENDATIONS_DOGS);
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
