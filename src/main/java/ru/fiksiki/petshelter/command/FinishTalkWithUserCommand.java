package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.step.AnswerDogUserStep;
import ru.fiksiki.petshelter.step.StepsContainer;
@Component
public class FinishTalkWithUserCommand extends Command {
    private final static String THANKS = "Спасибо за обращение!";

    private final StepsContainer container;

    private final SendMessageService sendMessageService;


    public FinishTalkWithUserCommand(SendMessageService sendMessageService, StepsContainer container) {
        super(CommandName.FINISH_TALK);
        this.container = container;
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        AnswerDogUserStep volunteerStep = (AnswerDogUserStep) container.getStepById(getId(update));
        long userId = volunteerStep.getUserId();
        container.deleteStep(userId);
        container.deleteStep(getId(update));
        SendMessage message = new SendMessage();
        message.setText(THANKS);
        message.setChatId(userId);
        sendMessageService.sendMessage(message);
    }
}
