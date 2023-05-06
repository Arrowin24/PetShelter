package ru.fiksiki.petshelter.step.talk;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.command.CommandName;
import ru.fiksiki.petshelter.command.volunteer.FinishTalkWithUserDogCommand;
import ru.fiksiki.petshelter.keyboard.volunteer.FinishDogVolunteerKeyBoard;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.step.Step;
import ru.fiksiki.petshelter.step.StepName;
import ru.fiksiki.petshelter.step.StepsContainer;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Log4j
public class AnswerDogUserStep extends Step {


    private long userId;

    public AnswerDogUserStep(StepsContainer container, SendMessageService sendMessageService) {
        super(container, sendMessageService);
    }


    @Override
    public void startStep(Update update) {
    }

    @Override
    public void doStep(Update update) {
        AnswerDogUserStep currentStep = (AnswerDogUserStep) getContainer().getStep(update);
        long userId = currentStep.getUserId();
        String updateText = update.getMessage().getText();
        SendMessage finish = new SendMessage();
        finish.setText("------------------");
        finish.setChatId(getId(update));
        finish.setReplyMarkup(new FinishDogVolunteerKeyBoard().getKeyBoard());
        getSendMessageService().sendMessage(finish);

        if (currentStep.getStep() == StepName.ONE) {
            if (updateText.equals(CommandName.FINISH_TALK_DOG_USER.getCommandName())) {
                FinishTalkWithUserDogCommand finishTalkWithUserDogCommand
                        = new FinishTalkWithUserDogCommand(getSendMessageService(), getContainer());
                finishTalkWithUserDogCommand.execute(update);
            } else {


                sendMessageToUser(update, userId);
            }
        }
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    private void sendMessageToUser(Update update, long userId) {
        SendMessage message = new SendMessage();
        message.setText(update.getMessage().getText());
        message.setChatId(userId);
        getSendMessageService().sendMessage(message);
    }
}
