package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.DogsKeyBoard;
import ru.fiksiki.petshelter.keyboard.StartKeyBoard;
import ru.fiksiki.petshelter.services.SendMessageService;
/**
 * The command that accesses the dog shelter menu
 */
@Component
public class DogsCommand extends Command{
    /**
     * Constructs a new DogsCommand instance with the specified SendMessageService
     *
     * @param sendMessageService  the SendMessageService to use for sending messages
     * @param String DOGS_MESSAGE  carries a text description
     */
    private final SendMessageService sendMessageService;
    public final static String DOGS_MESSAGE = "Приют для собак";

    public DogsCommand(SendMessageService sendMessageService) {
        super(CommandName.DOGS);
        this.sendMessageService = sendMessageService;
    }

    /**
     * Executes the DogsCommand with the specified Update.
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(DOGS_MESSAGE);
        message.setReplyMarkup(new DogsKeyBoard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }
}
