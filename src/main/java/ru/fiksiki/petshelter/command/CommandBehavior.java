package ru.fiksiki.petshelter.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface CommandBehavior {
    /***
     * Methode for execute command
     * @param update
     */
    void execute(Update update);


    /***
     * Get chatId from telegram
     * @param update
     * @return chatId
     */
    default long getId(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getChatId();
        }
        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getFrom().getId();
        }
        throw new RuntimeException("Проблема с установкой Id");
    }
}
