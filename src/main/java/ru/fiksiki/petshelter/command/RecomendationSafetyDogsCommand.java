package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Command describing dog shelter safety recommendations
 */
@Component
public class RecomendationSafetyDogsCommand extends Command {
    /**
     * Constructs a new RecommendationSafetyDogsCommand instance with the specified SendMessageService and ShelterInfoCommand
     *
     * @param sendMessageService  the SendMessageService to use for sending messages
     * @param ShelterInfoCommand.SAFETY_DOGS with safety information
     */
    private final SendMessageService sendMessageService;
    private ShelterInfoCommand RecomendationSafetyDogsCommand = ShelterInfoCommand.SAFETY_DOGS;

    public RecomendationSafetyDogsCommand(SendMessageService sendMessageService) {
        super(CommandName.RECOMMENDATIONS_SAFETY_DOGS);
        this.sendMessageService = sendMessageService;
    }

    /**
     * Sends a message with safety precautions at the dog shelter
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(String.valueOf(RecomendationSafetyDogsCommand));
        message.setReplyMarkup(new BackToMenuKeyboard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }
}
