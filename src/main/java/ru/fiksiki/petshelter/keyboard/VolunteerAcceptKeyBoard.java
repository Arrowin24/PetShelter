package ru.fiksiki.petshelter.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.fiksiki.petshelter.command.CommandName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VolunteerAcceptKeyBoard {


    public InlineKeyboardMarkup getKeyBoard(long id) {
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setCallbackData(CommandName.ACCEPT_USER_QUERY.getCommandName() + "&&" + id);
        button1.setText("Принять запрос пользователя");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Отклонить запрос пользователя");
        button2.setCallbackData(CommandName.DECLINE_USER_QUERY.getCommandName());
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(createButtonsLine(button1));
        keyboard.add(createButtonsLine(button2));
        return new InlineKeyboardMarkup(keyboard);
    }
    private List<InlineKeyboardButton> createButtonsLine(InlineKeyboardButton... button) {
        return Arrays.stream(button).collect(Collectors.toList());
    }
}
