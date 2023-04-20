package ru.fiksiki.petshelter.command;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Enum contains commands names. Command use names to link with telegram bot API
 */
@Getter
@AllArgsConstructor
public enum CommandName {
    START("/start"), //Команда старта доля начала работы с приложением
    HELP("/help"), // Команда вызова кнопки помощи

    UNKNOWN("/unknown"), // Name of UnknownCommand.java
    DOGS("/dogs"), // Команда вызова приюта для собак
    CATS("/cats"), //Команда вызова приюта для кошек
    INFO_SHELTER("/getInfo"), // Узнать информацию о приюте
    GET_PET_IS_SHELTER("/getPet"),//Как взять животное из приюта
    GET_REPORT_IS_PET("/getReport"), // Прислать отчет о питомце
    GET_VOLUNTEERS("/getVolunteers"); // Позвать волонтера

    private final String commandName;
}
