package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.CatsKeyBoard;
import ru.fiksiki.petshelter.keyboard.DogsKeyBoard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Сommand to exit back to the menu DogCommand
 */
@Component
public class BackToMenuDogCommand extends Command{
    /**
     * Constructs a new BackToMenuDogCommand instance with the specified SendMessageService
     * @param sendMessageService  the SendMessageService to use for sending messages
     */
    private final SendMessageService sendMessageService;


    public BackToMenuDogCommand(SendMessageService sendBotMessageService) {
        super(CommandName.BACK_TO_MENU_DOG);
        this.sendMessageService = sendBotMessageService;

    }

    /**
     * Executes the BackToMenuDogCommand with the specified Update.
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText("Выберите команду из списка:");
        message.setReplyMarkup(new DogsKeyBoard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }
}
