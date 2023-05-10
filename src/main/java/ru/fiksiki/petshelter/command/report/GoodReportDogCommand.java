package ru.fiksiki.petshelter.command.report;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.services.ProbationDogService;
import ru.fiksiki.petshelter.services.SendMessageService;

import java.time.LocalDate;

import static ru.fiksiki.petshelter.controller.TelegramBotController.SPLIT;

@Component
public class GoodReportDogCommand extends Command {
    private final ProbationDogService probationDogService;
    private final SendMessageService sendMessageService;

    public GoodReportDogCommand(ProbationDogService probationDogService, SendMessageService sendMessageService) {
        super(CommandName.GOOD_REPORT_DOG);
        this.probationDogService = probationDogService;
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        long userId = Long.parseLong(update.getCallbackQuery().getData().split(SPLIT)[1]);
        SendMessage message = new SendMessage();
        message.setChatId(userId);
        message.setText("Вы отправили хороший отчет. Продолжайте в том же духе");
        probationDogService.updateLastReportDate(userId, LocalDate.now());
        sendMessageService.sendMessage(message);
    }
}
