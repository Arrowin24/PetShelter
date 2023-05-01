package ru.fiksiki.petshelter.command.shedulle;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import ru.fiksiki.petshelter.services.SendMessageService;

@Component
public class ReportCommand {
    private final SendMessageService sendMessageService;

    public ReportCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Scheduled(cron = "00 00 12 * * *")
    private void remindReport() {
        SendMessage message = new SendMessage();
        message.setChatId(1207017951L);
        message.setText("Method repeats every "+ System.currentTimeMillis()/1000);
        sendMessageService.sendMessage(message);
    }


}
