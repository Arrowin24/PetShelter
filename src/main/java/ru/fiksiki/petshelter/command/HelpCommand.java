package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.services.SendMessageService;

@Component
public class HelpCommand extends Command{

    private final SendMessageService sendMessageService;
    private final static String HELP_MESSAGE = "Привет. Это команда помощи!!!";

    public HelpCommand(SendMessageService sendMessageService) {
        super(CommandName.HELP);
        this.sendMessageService=sendMessageService;
    }

    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(HELP_MESSAGE);
        sendMessageService.sendMessage(message);
    }
}
