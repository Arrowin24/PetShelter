package ru.fiksiki.petshelter.command.report;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.services.SendMessageService;


import static ru.fiksiki.petshelter.controller.TelegramBotController.SPLIT;

@Component
public class BadReportDogCommand extends Command {
    private final String TEXT = "Дорогой усыновитель, мы заметили, что ты заполняешь отчет не так подробно, как " +
            "необходимо. Пожалуйста, подойди ответственнее к этому занятию. В противном случае волонтеры приюта будут" +
            " обязаны самолично проверять условия содержания животного";
    private final SendMessageService sendMessageService;

    public BadReportDogCommand( SendMessageService sendMessageService) {
        super(CommandName.BAD_REPORT_DOG);
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        long userId = Long.parseLong(update.getCallbackQuery().getData().split(SPLIT)[1]);
        SendMessage message = new SendMessage();
        message.setChatId(userId);
        message.setText(TEXT);
        sendMessageService.sendMessage(message);
    }
}
