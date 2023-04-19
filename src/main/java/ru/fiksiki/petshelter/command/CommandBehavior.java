package ru.fiksiki.petshelter.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface CommandBehavior {
    /***
     * Methode to execute command
     * @param update get info from telegram chat
     */
    void execute(Update update);


    /***
     * Get chatId from telegram
     * @param update get info from telegram chat
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
