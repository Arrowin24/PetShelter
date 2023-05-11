package ru.fiksiki.petshelter.command.report;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import ru.fiksiki.petshelter.keyboard.ReportDogKeyBoard;
import ru.fiksiki.petshelter.model.ProbationCat;
import ru.fiksiki.petshelter.model.ProbationDog;
import ru.fiksiki.petshelter.services.ProbationCatService;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.services.ProbationDogService;

import java.time.LocalDate;
import java.util.List;

@Component
public class RepeatReportCommand {
    private final SendMessageService sendMessageService;

    private final ProbationDogService probationDogService;

    private final ProbationCatService probationCatService;

    public RepeatReportCommand(SendMessageService sendMessageService, ProbationDogService probationDogService,
                               ProbationCatService probationCatService) {
        this.sendMessageService = sendMessageService;
        this.probationDogService = probationDogService;
        this.probationCatService = probationCatService;
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
        List<ProbationCat> adoptersId = probationCatService.readAll();
        for (ProbationCat probationCat : adoptersId) {
            if (isProbationNow(probationCat)) {
                message.setChatId(probationCat.getId());
                message.setText("Пожалуйста отправьте отчет:");
                message.setReplyMarkup(new ReportDogKeyBoard().getKeyBoard());
                sendMessageService.sendMessage(message);
            }
        }
    }


    private boolean isProbationNow(ProbationDog probationDog) {
        if (probationDog.getLastReport().isAfter(LocalDate.now().minusDays(1))) {
            probationDog.setDayLeft(probationDog.getDayLeft() - 1);
            probationDogService.updateDayLeft(probationDog);
        }
        if (probationDog.getDayLeft() <= 0) {
            probationDogService.deleteProbation(probationDog);
            sendFinishProbation(probationDog.getId());
            return false;
        }
        return true;
    }

    private boolean isProbationNow(ProbationCat probationCat) {
        if (probationCat.getLastReport().isAfter(LocalDate.now().minusDays(1))) {
            probationCat.setDayLeft(probationCat.getDayLeft() - 1);
            probationCatService.updateDayLeft(probationCat);
        }
        if (probationCat.getDayLeft() <= 0) {
            probationCatService.deleteProbation(probationCat);
            sendFinishProbation(probationCat.getId());
            return false;
        }
        return true;
    }

    private void sendFinishProbation(long id) {
        SendMessage message = new SendMessage();
        message.setChatId(id);
        message.setText("Вы прекрасный хозяин животного. Вам больше не нужно отправлять отчеты. Большое вам спасибо");
        sendMessageService.sendMessage(message);
    }
}
