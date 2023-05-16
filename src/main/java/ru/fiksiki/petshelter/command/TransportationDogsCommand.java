package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;
/**
 * Command with the rules for transporting  dog from a shelter
 */
@Component
public class TransportationDogsCommand extends  Command {
    /**
     * * Constructs a new TransportationDogsCommand  instance with the specified SendMessageService and RecommendationsDogsCommand
     *
     * @param sendMessageService  the SendMessageService to use for sending messages
     * @param Enum recommendationsDogsCommand
     */
    private final SendMessageService sendMessageService;
    private RecommendationsDogsCommand recommendationsDogsCommand = RecommendationsDogsCommand.TRANSPORTATION_ADVICE_DOGS;

    public TransportationDogsCommand (SendMessageService sendMessageService) {
        super(CommandName.TRANSPORTATION_DOGS);
        this.sendMessageService = sendMessageService;
    }

    /**
     * Send message with the rules for transporting  dog from a shelter
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(String.valueOf(recommendationsDogsCommand));
        message.setReplyMarkup(new BackToMenuKeyboard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }
}


