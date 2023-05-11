package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.StartKeyBoard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Represents an unknown command.
 * This command is executed when the bot receives an unknown command from the user.
 * It sends a message to the user apologizing and suggesting that they contact a volunteer for help.
 */
@Component
public class UnknownCommand extends Command {

    /**
     * The text of the message to send to the user.
     */
    private final String TEXT = "Извините, я пока не могу помочь с этим вопросом. Обратитесь к волонтеру.";
    /**
     * The service used to send messages.
     */
    private final SendMessageService sendMessageService;

    /**
     * Constructs a new instance of the unknown command with the given send message service.
     *
     * @param sendMessageService the service to use for sending messages
     */
    public UnknownCommand(SendMessageService sendMessageService) {
        super(CommandName.UNKNOWN);
        this.sendMessageService = sendMessageService;
    }

    /**
     * Sends a message to the user apologizing for the unknown command and suggesting they contact a volunteer for help.
     *
     * @param update the update containing information about the incoming message
     */
    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(TEXT);
        message.setReplyMarkup(new StartKeyBoard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }
}
