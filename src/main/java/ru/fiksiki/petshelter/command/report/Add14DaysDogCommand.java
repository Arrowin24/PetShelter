package ru.fiksiki.petshelter.command.report;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.model.ProbationDog;
import ru.fiksiki.petshelter.services.ProbationDogService;
import ru.fiksiki.petshelter.services.SendMessageService;

import static ru.fiksiki.petshelter.controller.TelegramBotController.SPLIT;

@Component
public class Add14DaysDogCommand extends Command {
    private final ProbationDogService probationDogService;
    private final SendMessageService sendMessageService;

    public Add14DaysDogCommand(ProbationDogService probationDogService, SendMessageService sendMessageService)
    {
        super(CommandName.ADD_14_DAYS_DOG);
        this.probationDogService = probationDogService;
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        long userId = Long.parseLong(update.getCallbackQuery().getData().split(SPLIT)[1]);
        SendMessage message = new SendMessage();
        message.setChatId(userId);
        message.setText("На данный момент мы решили увеличить количество испытательного срока на 14 дней");
        ProbationDog probationDog = probationDogService.read(userId);
        probationDog.setDayLeft(probationDog.getDayLeft() + 14);
        probationDogService.updateDayLeft(probationDog);
        sendMessageService.sendMessage(message);
    }
}
