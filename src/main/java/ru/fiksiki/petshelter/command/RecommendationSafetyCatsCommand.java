package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

@Component
public class RecommendationSafetyCatsCommand extends Command{
    private final SendMessageService sendMessageService;
    private ShelterInfoCommand INFO = ShelterInfoCommand.SAFETY_CATS;

    public RecommendationSafetyCatsCommand(SendMessageService sendMessageService) {
        super(CommandName.RECOMMENDATIONS_SAFETY_CATS);
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(String.valueOf(INFO));
        message.setReplyMarkup(new BackToMenuKeyboard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }
}
