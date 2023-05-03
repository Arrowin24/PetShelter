package ru.fiksiki.petshelter.command.shedulle;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import ru.fiksiki.petshelter.keyboard.ReportDogKeyBoard;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.services.ProbationService;

import java.util.List;

@Component
public class ReportCommand {
    private final SendMessageService sendMessageService;

    private final ProbationService probationService;

    public ReportCommand(SendMessageService sendMessageService, ProbationService probationService) {
        this.sendMessageService = sendMessageService;
        this.probationService = probationService;
    }

    @Scheduled(cron = "00 00 12 * * *")
    private void reportDog() {
        SendMessage message = new SendMessage();
        List<Long> adoptersId = probationService.getAllAdopters();
        for (Long adId : adoptersId) {
            message.setChatId(adId);
            message.setText("Пожалуйста отправьте отчет:");
            message.setReplyMarkup(new ReportDogKeyBoard().getKeyBoard());
            sendMessageService.sendMessage(message);
        }
    }

    @Scheduled(cron = "00 00 12 * * *")
    private void reportCat() {
        SendMessage message = new SendMessage();
        message.setChatId(1207017951L);
        message.setText("Пожалуйста отправьте отчет:");
        message.setReplyMarkup(new ReportDogKeyBoard().getKeyBoard());
        sendMessageService.sendMessage(message);
    }


}
