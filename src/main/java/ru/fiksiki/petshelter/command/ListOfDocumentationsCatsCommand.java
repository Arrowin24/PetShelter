package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Command with information about the documents required for adopting a cat from a shelter
 */
@Component
public class ListOfDocumentationsCatsCommand extends Command {
    /**
     * Constructs a new ListOfDocumentationsCatsCommand  instance with the specified SendMessageService and  RecommendationsCatsCommand
     *
     * @param sendMessageService  the SendMessageService to use for sending messages
     * @param Enum recommendationsCatsCommand
     */
    private final SendMessageService sendMessageService;
    private RecommendationsCatsCommand recommendationsCatsCommand = RecommendationsCatsCommand.LIST_OF_DOCUMENTATIONS_CATS;

    public ListOfDocumentationsCatsCommand(SendMessageService sendMessageService) {
        super(CommandName.LIST_DOCUMENTATIONS_CATS);
        this.sendMessageService = sendMessageService;
    }

    /**
     * Sends a message with information about the documents required for adopting a cat from a shelter
     *
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(String.valueOf(recommendationsCatsCommand));
        message.setReplyMarkup(new BackToMenuKeyboard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }
}
