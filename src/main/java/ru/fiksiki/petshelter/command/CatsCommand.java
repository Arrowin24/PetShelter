package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.keyboard.CatsKeyBoard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * The command that accesses the cat shelter menu
 */

@Component
public class CatsCommand extends Command {
    /**
     * Constructs a new CatsCommand instance with the specified SendMessageService
     *
     * @param sendMessageService  the SendMessageService to use for sending messages
     * @param String CATS_MESSAGE  carries a text description
     */
    private final SendMessageService sendMessageService;
    private final static String CATS_MESSAGE = "Приют для кошек";

    public CatsCommand(SendMessageService sendMessageService) {
        super(CommandName.CATS);
        this.sendMessageService = sendMessageService;
    }

    /**
     * Executes the СatsCommand with the specified Update.
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(CATS_MESSAGE);
        message.setReplyMarkup(new CatsKeyBoard().getKeyBoard());
        sendMessageService.sendMessage(message);

    }
}
