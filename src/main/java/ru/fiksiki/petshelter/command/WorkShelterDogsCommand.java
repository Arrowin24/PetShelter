package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.BackToMenuKeyboard;
import ru.fiksiki.petshelter.services.SendMessageService;

@Component
public class WorkShelterDogsCommand extends Command {
    private final SendMessageService sendMessageService;
    private ShelterInfoCommand WorkShelterDogsCommand = ShelterInfoCommand.WORK_SCHEDULE_DOGS;

    public WorkShelterDogsCommand (SendMessageService sendMessageService) {
        super(CommandName.INFO_WORK_SCHEDULE_DOGS);
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(getId(update));
        message.setText(String.valueOf(WorkShelterDogsCommand));
        message.setReplyMarkup(new BackToMenuKeyboard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }
}
