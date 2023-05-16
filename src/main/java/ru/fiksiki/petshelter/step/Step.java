package ru.fiksiki.petshelter.step;


import ru.fiksiki.petshelter.services.SendMessageService;

public abstract class Step implements StepBehavior {
    private StepName step;

    private final StepsContainer container;
    private final SendMessageService sendBotMessageService;

    public Step(StepsContainer container, SendMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
        this.container = container;
    }

    public StepsContainer getContainer() {
        return container;
    }

    public SendMessageService getSendMessageService() {
        return sendBotMessageService;
    }

    public StepName getStep() {
        return step;
    }

    public void setStep(StepName step) {
        this.step = step;
    }
}
