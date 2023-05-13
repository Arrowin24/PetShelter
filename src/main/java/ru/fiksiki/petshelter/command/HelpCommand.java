package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * An implementation of the Command class that sends a help message.
 */
@Component
public class HelpCommand extends Command{

    private final SendMessageService sendMessageService;
    private final static String HELP_MESSAGE = "Привет. Это команда помощи!!!";

    /**
     * Constructs a new HelpCommand object.
     *
     * @param sendMessageService a service for sending messages
     */
    public HelpCommand(SendMessageService sendMessageService) {
        super(CommandName.HELP);
        this.sendMessageService=sendMessageService;
    }

    /**
     * Sends a help message to a chat user.
     *
     * @param update the update that triggered the HelpCommand object
     */
    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(HELP_MESSAGE);
        sendMessageService.sendMessage(message);
    }
}
