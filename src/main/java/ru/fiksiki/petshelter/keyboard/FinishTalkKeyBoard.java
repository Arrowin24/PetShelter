package ru.fiksiki.petshelter.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.fiksiki.petshelter.command.CommandName;

import java.util.ArrayList;
import java.util.List;

public class FinishTalkKeyBoard {


    //    public InlineKeyboardMarkup getKeyBoard() {
//        InlineKeyboardButton button1 = createButton("Завершить", CommandName.FINISH_TALK);
//        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
//        keyboard.add(createButtonsLine(button1));
//        return new InlineKeyboardMarkup(keyboard);
//    }
    public ReplyKeyboardMarkup getKeyBoard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create a list of keyboard rows
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a new keyboard row
        KeyboardRow row = new KeyboardRow();
        // Add buttons to the row
        row.add(CommandName.FINISH_TALK.getCommandName());
        // Add the row to the keyboard
        keyboard.add(row);
        // Set the keyboard to the markup object
        keyboardMarkup.setKeyboard(keyboard);
        // Set the markup object to resize the keyboard
        keyboardMarkup.setResizeKeyboard(true);
        return keyboardMarkup;
    }
}
