package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Command with information about the work schedule of the cats shelter
 */
@Component
public class WorkScheduleCatsCommand extends Command {
    /**
     * Constructs a new WorkScheduleCatsCommand instance with the specified SendMessageService and ShelterInfoCommand
     *
     * @param sendMessageService  the SendMessageService to use for sending messages
     * @param ShelterInfoCommand.WORK_SCHEDULE_CATS with the work schedule information
     */
    private final SendMessageService sendMessageService;
    private ShelterInfoCommand INFO = ShelterInfoCommand.WORK_SCHEDULE_CATS;

    public WorkScheduleCatsCommand(SendMessageService sendMessageService) {
        super(CommandName.INFO_WORK_SCHEDULE_CATS);
        this.sendMessageService = sendMessageService;
    }
    /**
     * Sends a message with the work schedule information for cats shelter
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
