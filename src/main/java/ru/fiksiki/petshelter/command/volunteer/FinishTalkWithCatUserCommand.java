package ru.fiksiki.petshelter.command.volunteer;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.Command;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.step.talk.AnswerCatUserStep;
import ru.fiksiki.petshelter.step.StepsContainer;

/**
 * Command to finish a conversation with cat's user. Executes by a volunteer from cat's shelter
 */
@Component
public class FinishTalkWithCatUserCommand extends Command {
    private final static String THANKS = "Спасибо за обращение!";

    private final StepsContainer container;

    private final SendMessageService sendMessageService;

    /**
     * Constructs the new instance of FinishTalkWithUserCatCommand
     *
     * @param sendMessageService the service for a sending messages
     * @param container          container for a saving the steps
     */
    public FinishTalkWithCatUserCommand(SendMessageService sendMessageService, StepsContainer container) {
        super(CommandName.FINISH_TALK_CAT_USER);
        this.container = container;
        this.sendMessageService = sendMessageService;
    }

    /**
     * Executes the FinishTalkWithCatUserCommand
     *
     * @param update get info from telegram chat
     */
    @Override
    public void execute(Update update) {
        AnswerCatUserStep volunteerStep = (AnswerCatUserStep) container.getStepById(getId(update));
        long userId = volunteerStep.getUserId();
        container.deleteStep(userId);
        container.deleteStep(getId(update));
        SendMessage message = new SendMessage();
        message.setText(THANKS);
        message.setChatId(userId);
        sendMessageService.sendMessage(message);
    }
}
