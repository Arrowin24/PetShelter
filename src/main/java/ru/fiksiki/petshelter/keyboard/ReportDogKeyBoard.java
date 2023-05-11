package ru.fiksiki.petshelter.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.fiksiki.petshelter.command.CommandName;

import java.util.ArrayList;
import java.util.List;

/**
 * This class creates an inline keyboard markup for reporting dog-related activities.
 * Implements the {@link KeyBoard} interface.
 */
public class ReportDogKeyBoard implements KeyBoard {

    /**
     * Creates and returns an inline keyboard markup.
     *
     * @return the {@link InlineKeyboardMarkup} object containing the inline keyboard markup
     */
    @Override
    public InlineKeyboardMarkup getKeyBoard() {
        InlineKeyboardButton button1 = createButton("Отправить отчет", CommandName.REPORT_DOG);
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(createButtonsLine(button1));
        return new InlineKeyboardMarkup(keyboard);
    }
}
