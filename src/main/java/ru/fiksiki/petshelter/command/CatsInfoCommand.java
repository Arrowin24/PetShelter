package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.keyboard.CatsKeyBoard;
import ru.fiksiki.petshelter.keyboard.InfoShelterCatsKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Сat shelter menu command
 */
@Component
public class CatsInfoCommand  extends Command{
    /**
     * Constructs a new CatsCommand instance with the specified SendMessageService and ShelterInfoCommand
     *
     *       @param sendMessageService  the SendMessageService to use for sending messages
     *       @param Enum ShelterInfoCommand.CATS
     */

    private final SendMessageService sendMessageService;
    private ShelterInfoCommand INFO = ShelterInfoCommand.CATS;

    public CatsInfoCommand(SendMessageService sendMessageService) {
        super(CommandName.INFO_CATS);
        this.sendMessageService = sendMessageService;
    }

    /**
     * Sends a message with the output of cats shelter commands
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(String.valueOf(INFO));
        message.setReplyMarkup(new InfoShelterCatsKeyboard().getKeyBoard());
        sendMessageService.sendMessage(message);
        message.setReplyMarkup(new BackToMenuKeyboard().getKeyBoard());

    }
}
