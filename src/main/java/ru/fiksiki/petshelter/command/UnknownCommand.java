package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.StartKeyBoard;
import ru.fiksiki.petshelter.services.SendMessageService;

/**
 * Command displays a message about necessary steps to help a user with unknown command.
 */
@Component
public class UnknownCommand extends Command {

    private final String TEXT = "Извините я пока что не могу вам с этим помочь. Можете с данным вопросом обратиться к волонтеру.";

    private final SendMessageService sendMessageService;

    public UnknownCommand(SendMessageService sendMessageService) {
        super(CommandName.UNKNOWN);
        this.sendMessageService=sendMessageService;
    }

    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(TEXT);
        message.setReplyMarkup(new StartKeyBoard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }


}
