package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

@Component
public class RecomendationSafetyDogsCommand extends Command{
    private final SendMessageService sendMessageService;
    private ShelterInfoCommand RecomendationSafetyDogsCommand = ShelterInfoCommand.SAFETY_DOGS;

    public RecomendationSafetyDogsCommand (SendMessageService sendMessageService) {
        super(CommandName.RECOMMENDATIONS_SAFETY_DOGS);
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(String.valueOf(RecomendationSafetyDogsCommand));
        message.setReplyMarkup(new BackToMenuKeyboard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }
}
