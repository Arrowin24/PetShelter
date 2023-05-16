package ru.fiksiki.petshelter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.controller.TelegramBotController;
import ru.fiksiki.petshelter.keyboard.KeyBoard;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.services.impl.SendMessageServiceImpl;

abstract class AbstractCommandTest {
    protected TelegramBotController telegramBotController = Mockito.mock(TelegramBotController.class);
    protected SendMessageService sendBotMessageService = new SendMessageServiceImpl(telegramBotController);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();
    abstract InlineKeyboardMarkup getKeyboard();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        //given
        Long chatId = 1234567824356L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        Mockito.when(message.getReplyMarkup()).thenReturn(( getKeyboard()));
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.setReplyMarkup(getKeyboard());


        //when
        getCommand().execute(update);

        //then
        Mockito.verify(telegramBotController).execute(sendMessage);
    }
}
