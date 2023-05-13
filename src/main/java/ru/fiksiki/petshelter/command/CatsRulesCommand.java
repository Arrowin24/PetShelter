package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.keyboard.InfoShelterCatsKeyboard;
import ru.fiksiki.petshelter.keyboard.RecommendationCatsKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

@Component
public class CatsRulesCommand extends Command{
    private final SendMessageService sendMessageService;
    private RecommendationsCatsCommand recommendationsCatsCommand = RecommendationsCatsCommand.CATS_INTRODUCTION_RULES;

    public CatsRulesCommand(SendMessageService sendMessageService) {
        super(CommandName.CATS_RULES);
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(String.valueOf(recommendationsCatsCommand));
        message.setReplyMarkup(new BackToMenuKeyboard().getKeyBoard());
        sendMessageService.sendMessage(message);

    }
}
