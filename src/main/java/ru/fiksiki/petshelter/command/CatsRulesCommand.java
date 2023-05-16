package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.keyboard.InfoShelterCatsKeyboard;
import ru.fiksiki.petshelter.keyboard.RecommendationCatsKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Cats rules info Command
 */
@Component
public class CatsRulesCommand extends Command{
    /**
     * Constructs a new СatsRulesCommand instance with the specified SendMessageService and  RecommendationsCatsCommand
     *
     *       @param sendMessageService  the SendMessageService to use for sending messages
     *       @param Enum recommendationsCatsCommand
     */

    private final SendMessageService sendMessageService;
    private RecommendationsCatsCommand recommendationsCatsCommand = RecommendationsCatsCommand.CATS_INTRODUCTION_RULES;

    public CatsRulesCommand(SendMessageService sendMessageService) {
        super(CommandName.CATS_RULES);
        this.sendMessageService = sendMessageService;
    }

    /**
     * Sends a message with the rules of being in a cat shelter
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
