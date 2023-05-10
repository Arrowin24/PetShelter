package ru.fiksiki.petshelter.command.report;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import ru.fiksiki.petshelter.keyboard.ReportDogKeyBoard;
import ru.fiksiki.petshelter.model.ProbationDog;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.services.ProbationDogService;

import java.time.LocalDate;
import java.util.List;

@Component
public class RepeatReportCommand {
    private final SendMessageService sendMessageService;

    private final ProbationDogService probationDogService;

    public RepeatReportCommand(SendMessageService sendMessageService, ProbationDogService probationDogService) {
        this.sendMessageService = sendMessageService;
        this.probationDogService = probationDogService;
    }

    @Scheduled(cron = "00 00 12 * * *")
    private void reportDog() {
        SendMessage message = new SendMessage();
        List<ProbationDog> adoptersId = probationDogService.readAll();
        for (ProbationDog probationDog : adoptersId) {
            if (isProbationNow(probationDog)) {
                message.setChatId(probationDog.getId());
                message.setText("Пожалуйста отправьте отчет:");
                message.setReplyMarkup(new ReportDogKeyBoard().getKeyBoard());
                sendMessageService.sendMessage(message);
            }
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


    private boolean isProbationNow (ProbationDog probationDog) {
        if (probationDog.getLastReport().isAfter(LocalDate.now().minusDays(1))) {
            probationDog.setDayLeft(probationDog.getDayLeft() - 1);
            probationDogService.updateDayLeft(probationDog);
        }
        if (probationDog.getDayLeft()<=0){
            probationDogService.deleteProbation(probationDog);
            sendFinishProbation(probationDog);
            return false;
        }
        return true;
    }

    private void sendFinishProbation(ProbationDog probationDog){
        SendMessage message = new SendMessage();
        message.setChatId(probationDog.getId());
        message.setText("Вы прекрасный хозяин животного. Вам больше не нужно отправлять отчеты. Большое вам спасибо");
        sendMessageService.sendMessage(message);
    }


}
