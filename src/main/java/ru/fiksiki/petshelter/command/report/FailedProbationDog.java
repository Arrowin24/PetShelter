package ru.fiksiki.petshelter.command.report;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.services.SendMessageService;


import static ru.fiksiki.petshelter.controller.TelegramBotController.SPLIT;

@Component
public class FailedProbationDog extends Command {
    public FailedProbationDog(SendMessageService sendMessageService) {
        super(CommandName.FAILED_PROBATION_DOG);
        this.sendMessageService = sendMessageService;
    }

    private final SendMessageService sendMessageService;

    @Override
    public void execute(Update update) {
        long userId = Long.parseLong(update.getCallbackQuery().getData().split(SPLIT)[1]);
        SendMessage message = new SendMessage();
        message.setChatId(userId);
        message.setText(
                "К несчастью вы не прошли испытательный срок. Скоро с вами свяжется волонтер и расскажет вам " +
                        "дальнейшие шаги");
        sendMessageService.sendMessage(message);
    }
}
