package ru.fiksiki.petshelter.step.talk;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.keyboard.volunteer.DogVolunteerAcceptKeyBoard;
import ru.fiksiki.petshelter.model.VolunteerDog;
import ru.fiksiki.petshelter.services.SendMessageService;
import ru.fiksiki.petshelter.services.VolunteerDogService;
import ru.fiksiki.petshelter.step.Step;
import ru.fiksiki.petshelter.step.StepName;
import ru.fiksiki.petshelter.step.StepsContainer;

import java.util.List;
@Log4j
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Service
public class CallDogVolunteerStep extends Step {

    private final VolunteerDogService volunteerDogService;
    private final static String START_TEXT = "Ожидайте, волонтёр уже спешит на помощь";

    private final static String ALARM_TEXT = "Пользователю %s необходима помощь";


    private long volunteerId;

    public CallDogVolunteerStep(StepsContainer container, SendMessageService sendBotMessageService, VolunteerDogService volunteerDogService) {
        super(container, sendBotMessageService);
        this.volunteerDogService = volunteerDogService;
    }


    @Override
    public void startStep(Update update) {
        long id = getId(update);
        CallDogVolunteerStep callDogVolunteerStep = new CallDogVolunteerStep(getContainer(),
                getSendMessageService(),
                volunteerDogService);
        callDogVolunteerStep.setStep(StepName.ZERO);
        getContainer().putStep(id, callDogVolunteerStep);
        SendMessage message = new SendMessage();
        message.setChatId(id);
        message.setText(START_TEXT);
        getSendMessageService().sendMessage(message);

        List<VolunteerDog> volunteers = volunteerDogService.getAll();
        SendMessage alarmMessage = new SendMessage();
        volunteers.stream().forEach(v -> {
            alarmMessage.setChatId(v.getId());
            alarmMessage.setText(String.format(ALARM_TEXT, id));
            alarmMessage.setReplyMarkup(new DogVolunteerAcceptKeyBoard().getKeyBoard(id));
            getSendMessageService().sendMessage(alarmMessage);
        });

    }

    @Override
    public void doStep(Update update) {
        CallDogVolunteerStep currentStep = (CallDogVolunteerStep) getContainer().getStep(update);
        long volunteerId = currentStep.getVolunteerId();
        if (currentStep.getStep() == StepName.ONE) {
            sendMessageToVolunteer(update, volunteerId);
        }
    }

    public long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(long volunteerId) {
        this.volunteerId = volunteerId;
    }
    private void sendMessageToVolunteer(Update update, long volunteerId) {
        SendMessage message = new SendMessage();
        message.setText(update.getMessage().getText());
        message.setChatId(volunteerId);
        getSendMessageService().sendMessage(message);
    }
}
