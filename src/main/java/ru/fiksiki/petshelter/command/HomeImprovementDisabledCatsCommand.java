package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Command with rules for decorating a house for a disabled cat
 */
@Component
public class HomeImprovementDisabledCatsCommand extends Command {
    /**
     * Constructs a new  HomeImprovementCatsCommand instance with the specified SendMessageService and  RecommendationsCatsCommand
     *
     * @param sendMessageService  the SendMessageService to use for sending messages
     * @param Enum recommendationsCatsCommand
     */
    private final SendMessageService sendMessageService;
    private RecommendationsCatsCommand recommendationsCatsCommand = RecommendationsCatsCommand.HOME_IMPROVEMENT_DISABLED_CATS;

    public HomeImprovementDisabledCatsCommand(SendMessageService sendMessageService) {
        super(CommandName.HOME_IMPROVEMENT_DISABLED_CATS);
        this.sendMessageService = sendMessageService;
    }

    /**
     * Sends a message house rules
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
