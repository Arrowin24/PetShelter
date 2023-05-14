package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Command with rules for not adopting a dog from a shelter
 */
@Component
public class ReasonsForRefusalDogsCommand extends Command {
    /**
     * Constructs a new ReasonsForRefusalCatsCommand  instance with the specified SendMessageService and RecommendationsDogsCommand
     *
     * @param sendMessageService  the SendMessageService to use for sending messages
     * @param Enum recommendationsDogsCommand
     */
    private final SendMessageService sendMessageService;
    private RecommendationsDogsCommand recommendationsDogsCommand = RecommendationsDogsCommand.REASONS_FOR_REFUSAL_DOGS;

    public ReasonsForRefusalDogsCommand(SendMessageService sendMessageService) {
        super(CommandName.REASONS_FOR_REFUSAL_DOGS);
        this.sendMessageService = sendMessageService;
    }

    /**
     * Sends a message about the right to refuse adoption from the shelter
     *
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
