package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.step.SendReportStep;
/**
 * An implementation of the Command class that executes the Report Dog command.
 */
@Component
public class ReportDogCommand extends Command{
    private final SendReportStep sendReportStep;

    public ReportDogCommand( SendReportStep sendReportStep) {
        super(CommandName.REPORT_DOG);
        this.sendReportStep = sendReportStep;
    }

    /**
     * Executes the Report Dog command by starting the sendReportStep for the given update.
     *
     * @param update the update that triggered the ReportDogCommand object
     */
    @Override
    public void execute(Update update) {
        sendReportStep.startStep(update);
    }
}
