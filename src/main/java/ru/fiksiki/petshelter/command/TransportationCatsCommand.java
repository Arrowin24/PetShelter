package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Command with the rules for transporting  cat from a shelter
 */
@Component
public class TransportationCatsCommand extends Command {
    /**
     * * Constructs a new TransportationCatsCommand  instance with the specified SendMessageService and RecommendationsCatsCommand
     *
     * @param sendMessageService  the SendMessageService to use for sending messages
     * @param Enum recommendationsCatsCommand
     */
    private final SendMessageService sendMessageService;
    private RecommendationsCatsCommand recommendationsCatsCommand = RecommendationsCatsCommand.TRANSPORTATION_ADVICE_CATS;

    public TransportationCatsCommand(SendMessageService sendMessageService) {
        super(CommandName.TRANSPORTATION_CATS);
        this.sendMessageService = sendMessageService;
    }
    /**
     * Send message with the rules for transporting  cats from a shelter
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
