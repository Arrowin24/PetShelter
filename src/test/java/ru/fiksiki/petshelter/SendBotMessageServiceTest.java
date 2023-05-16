package ru.fiksiki.petshelter;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;
import ru.fiksiki.petshelter.controller.TelegramBotController;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.services.impl.SendMessageServiceImpl;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {
    @MockBean
    private SendMessageService sendMessageService;
    @MockBean
    private TelegramBotController telegramBot;

    @BeforeEach
    public void init() {
        telegramBot = Mockito.mock(TelegramBotController.class);
        sendMessageService = new SendMessageServiceImpl(telegramBot);
    }
    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        long chatId = 45454;
        String message = "test_message";


        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);


        //when
        sendMessageService.sendMessage(sendMessage);

        //then
        Mockito.verify(telegramBot).execute(sendMessage);
    }
}
