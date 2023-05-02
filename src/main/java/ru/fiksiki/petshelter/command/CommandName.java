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
    GET_DOG_VOLUNTEER("/getDogVolunteer"), // Позвать волонтера из приюта для собак
    ACCEPT_USER_QUERY("/acptQ"), //Принять запрос от пользователя
    DECLINE_USER_QUERY("/dclnQ"),//Отклонить запрос от пользователя
    FINISH_TALK("/fin"), //Завершить разговор с пользователем
    INFO_CATS("/infocats"), //Информация о приюте кошек
    INFO_DOGS("/infodogs"), //Информация о приюте собак
    INFO_WORK_SCHEDULE_DOGS("/worksheduledogs"), // Информация о времени работы приюта для собак и адрес приюта
    INFO_WORK_SCHEDULE_CATS("/workshedulecats"),// Информация о времени работы приюта для кошек и адрес приюта
    CONTACT_SECURITY_CATS("/contactsecuritycats"), //Контактные данные охраны для оформления пропуска в приют для кошек
    CONTACT_SECURITY_DOGS("/contactsecuritydogs"), //Контактные данные охраны для оформления пропуска в приют для собак
    RECOMMENDATIONS_SAFETY_CATS("/infosafetycats"), //Правила безопасности в приюте для кошек
    RECOMMENDATIONS_SAFETY_DOGS("/infosafetydogs"),//Правила безопасности в приюте для собак
    CREATE_DOG_VOLUNTEER("/createDogVolunteer"), //Create dogs shelter volunteer command name
    BACK_TO_MENU("/backtomenu"); // Кнопка выхода в предыдущее меню

    private final String commandName;
}
