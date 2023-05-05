package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.step.SendReportStep;
@Component
public class ReportDogCommand extends Command{
    private final SendReportStep sendReportStep;

    public ReportDogCommand( SendReportStep sendReportStep) {
        super(CommandName.REPORT_DOG);
        this.sendReportStep = sendReportStep;
    }

    @Override
    public void execute(Update update) {
        sendReportStep.startStep(update);
    }
}
