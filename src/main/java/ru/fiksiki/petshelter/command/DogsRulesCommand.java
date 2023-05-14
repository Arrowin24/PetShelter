package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Dog rules info command
 */
@Component
public class DogsRulesCommand extends Command{
    /**
     * Constructs a new DogsRulesCommand instance with the specified SendMessageService and  RecommendationsDogsCommand
     *
     *       @param sendMessageService  the SendMessageService to use for sending messages
     *       @param Enum recommendationsDogsCommand
     */

    private final SendMessageService sendMessageService;

    private RecommendationsDogsCommand recommendationsDogsCommand = RecommendationsDogsCommand.DOGS_INTRODUCTION_RULES;

    public DogsRulesCommand(SendMessageService sendMessageService) {
        super(CommandName.DOGS_RULES);
        this.sendMessageService = sendMessageService;
    }
    /**
     * Sends a message with the rules of being in a dog shelter
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
