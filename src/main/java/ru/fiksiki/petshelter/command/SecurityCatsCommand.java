package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Command with the contacts of the protection of the cats shelter
 */
@Component
public class SecurityCatsCommand extends Command{
    /**
     * Constructs a new SecurityCatsCommand instance with the specified SendMessageService and ShelterInfoCommand
     *
     * @param sendMessageService  the SendMessageService to use for sending messages
     * @param ShelterInfoCommand.SECURITY_CATS the ShelterInfoCommand with security information
     */

    private final SendMessageService sendMessageService;
    private final ShelterInfoCommand INFO = ShelterInfoCommand.SECURITY_CATS;

    public SecurityCatsCommand(SendMessageService sendMessageService) {
        super(CommandName.CONTACT_SECURITY_CATS);
        this.sendMessageService = sendMessageService;
    }
    /**
     * Sends a message with contacts security of the cats shelter
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(String.valueOf(INFO));
        message.setReplyMarkup(new BackToMenuKeyboard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }
}
