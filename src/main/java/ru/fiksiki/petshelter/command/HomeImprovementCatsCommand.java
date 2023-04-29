package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

@Component
public class HomeImprovementCatsCommand extends Command {
    private final SendMessageService sendMessageService;
    private RecommendationsCatsCommand recommendationsCatsCommand = RecommendationsCatsCommand.HOME_IMPROVEMENT_CATS;

    public HomeImprovementCatsCommand(SendMessageService sendMessageService) {
        super(CommandName.HOME_IMPROVEMENT_CATS);
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
