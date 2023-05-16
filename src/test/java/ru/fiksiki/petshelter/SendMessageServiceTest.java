package ru.fiksiki.petshelter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.fiksiki.petshelter.controller.TelegramBotController;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.services.impl.SendMessageServiceImpl;

/**
 * This class contains test for the SendMessageService
 *
 */
@DisplayName("Unit tests for the SendMessageService")
public class SendMessageServiceTest {
    private SendMessageService sendMessageService;
    private TelegramBotController telegramBot;

    /**
     * this method allows to create objects before each test
     */
    @BeforeEach
    public void init() {
        telegramBot = Mockito.mock(TelegramBotController.class);
        sendMessageService = new SendMessageServiceImpl(telegramBot);

    }

    /**
     * This test allows to check that the SendMessageService is called correctly.
     * @throws TelegramApiException
     */
    @Test
    public void shouldCorrectlySendMessage() throws TelegramApiException {
        //given
        long chatId = 1L;
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
