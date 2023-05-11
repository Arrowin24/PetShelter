package ru.fiksiki.petshelter.keyboard.answer;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.fiksiki.petshelter.command.CommandName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReportCatAnswerKeyBoard {

    public InlineKeyboardMarkup getKeyBoard(long probationID) {
        InlineKeyboardButton button0 = new InlineKeyboardButton();
        button0.setCallbackData(CommandName.GOOD_REPORT_CAT.getCommandName() + "&&" + probationID);
        button0.setText("Хороший отчет");
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setCallbackData(CommandName.BAD_REPORT_CAT.getCommandName() + "&&" + probationID);
        button1.setText("Плохой отчет");
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setCallbackData(CommandName.ADD_14_DAYS_CAT.getCommandName() + "&&" + probationID);
        button2.setText("Добавить 14 дней");
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setCallbackData(CommandName.ADD_30_DAYS_CAT.getCommandName() + "&&" + probationID);
        button3.setText("Добавить 30 дней");
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setCallbackData(CommandName.FAILED_PROBATION_CAT.getCommandName() + "&&" + probationID);
        button4.setText("Не прошел испытательный");
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(createButtonsLine(button0));
        keyboard.add(createButtonsLine(button1));
        keyboard.add(createButtonsLine(button2));
        keyboard.add(createButtonsLine(button3));
        keyboard.add(createButtonsLine(button4));
        return new InlineKeyboardMarkup(keyboard);
    }

    private List<InlineKeyboardButton> createButtonsLine(InlineKeyboardButton... button) {
        return Arrays.stream(button).collect(Collectors.toList());
    }
}
