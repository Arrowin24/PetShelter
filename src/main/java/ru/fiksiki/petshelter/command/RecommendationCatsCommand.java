package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.keyboard.InfoShelterDogsKeyboard;
import ru.fiksiki.petshelter.keyboard.RecommendationCatsKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;
@Component
public class RecommendationCatsCommand extends Command{

    private final SendMessageService sendMessageService;
    private final static String INFO_MESSAGE = "Рекомендации для будущих хозяев кошки/кота";

    public RecommendationCatsCommand(SendMessageService sendMessageService) {
        super(CommandName.RECOMMENDATIONS_CATS);
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(INFO_MESSAGE);
        message.setReplyMarkup(new RecommendationCatsKeyboard().getKeyBoard());
        sendMessageService.sendMessage(message);
        message.setReplyMarkup(new BackToMenuKeyboard().getKeyBoard());
    }
}
