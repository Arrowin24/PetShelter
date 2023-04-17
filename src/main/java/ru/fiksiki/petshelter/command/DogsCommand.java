package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.DogsKeyBoard;
import ru.fiksiki.petshelter.keyboard.StartKeyBoard;
import ru.fiksiki.petshelter.services.SendMessageService;

@Component
public class DogsCommand extends Command{

    private final SendMessageService sendMessageService;
    private final static String DOGS_MESSAGE = "Приют для собак";

    public DogsCommand(SendMessageService sendMessageService) {
        super(CommandName.DOGS);
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(DOGS_MESSAGE);
        message.setReplyMarkup(new DogsKeyBoard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }
}
