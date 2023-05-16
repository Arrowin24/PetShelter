package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.StartKeyBoard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Сommand to launch the bot
 */
@Component
public class StartCommand extends Command{

    /**
     * Constructs a new RecommendationSafetyCatsCommand instance with the specified SendMessageService and ShelterInfoCommand
     *
     * @param sendMessageService  the SendMessageService to use for sending messages
     * @param START_MESSAGE with information about shelters
     */
    private final SendMessageService sendMessageService;
    public final static String START_MESSAGE = "Привет. Я телеграм бот, вет клиники." + " Выберете пожалуйста нужный вам приют : " ;

    public StartCommand(SendMessageService sendMessageService) {
        super(CommandName.START);
        this.sendMessageService = sendMessageService;
    }
    /**
     * Sends start message for choosing a shelter
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(START_MESSAGE);
        message.setReplyMarkup(new StartKeyBoard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }
}
