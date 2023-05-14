package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.keyboard.InfoShelterDogsKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;
/**
 * Dog shelter menu command
 */
@Component
public class DogsInfoCommand  extends Command{
    /**
     * Constructs a new DogsCommand instance with the specified SendMessageService and ShelterInfoCommand
     *
     *       @param sendMessageService  the SendMessageService to use for sending messages
     *       @param Enum ShelterInfoCommand.DOGS
     */
    private final SendMessageService sendMessageService;
    private ShelterInfoCommand Info = ShelterInfoCommand.DOGS;

    public DogsInfoCommand (SendMessageService sendMessageService) {
        super(CommandName.INFO_DOGS);
        this.sendMessageService = sendMessageService;
    }

    /**
     * Sends a message with the output of dog shelter commands
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(String.valueOf(Info));
        message.setReplyMarkup(new InfoShelterDogsKeyboard().getKeyBoard());
        sendMessageService.sendMessage(message);
        message.setReplyMarkup(new BackToMenuKeyboard().getKeyBoard());
    }
}
