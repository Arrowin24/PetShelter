package ru.fiksiki.petshelter.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.command.ShelterInfoCommand;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface KeyBoard {

    InlineKeyboardMarkup getKeyBoard();

    default InlineKeyboardButton createButton(String text, CommandName command) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(text);
        button.setCallbackData(command.getCommandName());
        return button;
    }
    default InlineKeyboardButton createButton(String text, ShelterInfoCommand command) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(text);
        button.setCallbackData(command.getShelterName());
        return button;
    }


    default List<InlineKeyboardButton> createButtonsLine(InlineKeyboardButton... button) {
        return Arrays.stream(button).collect(Collectors.toList());
    }
}
