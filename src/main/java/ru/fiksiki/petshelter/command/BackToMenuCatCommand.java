package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.CatsKeyBoard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Сommand to exit back to the menu CatCommand
 */
@Component
public class BackToMenuCatCommand extends Command {
    /**
     *Constructs a new BackToMenuCatCommand instance with the specified SendMessageService
     * @param sendMessageService  the SendMessageService to use for sending messages
     */

    private final SendMessageService sendMessageService;


    public BackToMenuCatCommand(SendMessageService sendBotMessageService) {
        super(CommandName.BACK_TO_MENU_CAT);
        this.sendMessageService = sendBotMessageService;

    }

    /**
     * Executes the BackToMenuCatCommand with the specified Update.
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText("Выберите команду из списка:");
        message.setReplyMarkup(new CatsKeyBoard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }
}
