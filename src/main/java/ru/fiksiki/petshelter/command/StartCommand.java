package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.StartKeyBoard;
import ru.fiksiki.petshelter.services.SendMessageService;

@Component
public class StartCommand extends Command{

    private final SendMessageService sendMessageService;
    private final static String START_MESSAGE = "Привет. Я телеграм бот, вет клиники." + " Выберете пожалуйста нужный вам приют : " ;

    public StartCommand(SendMessageService sendMessageService) {
        super(CommandName.START);
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(START_MESSAGE);
        message.setReplyMarkup(new StartKeyBoard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }
}
