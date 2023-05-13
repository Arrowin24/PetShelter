package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.keyboard.CatsKeyBoard;
import ru.fiksiki.petshelter.services.SendMessageService;


@Component
public class CatsCommand extends Command{
    private final SendMessageService sendMessageService;
    private final static String CATS_MESSAGE = "Приют для кошек";

    public CatsCommand(SendMessageService sendMessageService) {
        super(CommandName.CATS);
        this.sendMessageService= sendMessageService;
    }

    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(CATS_MESSAGE);
        message.setReplyMarkup(new CatsKeyBoard().getKeyBoard());
        sendMessageService.sendMessage(message);

    }
}
