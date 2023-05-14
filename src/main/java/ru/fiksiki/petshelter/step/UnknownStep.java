package ru.fiksiki.petshelter.step;


import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.fiksiki.petshelter.services.SendMessageService;

@Component
public class UnknownStep extends Step {
    public UnknownStep(StepsContainer container, SendMessageService sendBotMessageService) {
        super(container, sendBotMessageService);
    }

    @Override
    public void startStep(Update update) {

    }

    @Override
    public void doStep(Update update) {
        long id = update.getMessage().getChatId();
        SendMessage message = new SendMessage();
        message.setChatId(id);
        message.setText("Моя тебя не понимать");
        getSendMessageService().sendMessage(message);
    }
}
