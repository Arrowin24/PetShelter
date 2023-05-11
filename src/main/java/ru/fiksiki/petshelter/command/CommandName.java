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
    REPORT_DOG("/report_dog"), // Прислать отчет о питомце собаке
    REPORT_CAT("/report_cat"), // Прислать отчет о питомце кошке
    GET_DOG_VOLUNTEER("/getDogVolunteer"), // Позвать волонтера из приюта для собак
    GET_CAT_VOLUNTEER("/getCatVolunteer"), // Позвать волонтера из приюта для кошек
    ACCEPT_DOG_USER_QUERY("/acDQ"), //Принять запрос от пользователя. Приют для собак
    DECLINE_DOG_USER_QUERY("/dcDQ"),//Отклонить запрос от пользователя. Приют для собак
    ACCEPT_CAT_USER_QUERY("/acCQ"), //Принять запрос от пользователя. Приют для кошек
    DECLINE_CAT_USER_QUERY("/dcCQ"),//Отклонить запрос от пользователя. Приют для кошек
    FINISH_TALK_DOG_USER("/finDog"), //Завершить разговор с пользователем. Приют для собак
    FINISH_TALK_CAT_USER("/finCat"), //Завершить разговор с пользователем. Приют для кошек
    INFO_CATS("/infocats"), //Информация о приюте кошек
    INFO_DOGS("/infodogs"), //Информация о приюте собак
    INFO_WORK_SCHEDULE_DOGS("/worksheduledogs"), // Информация о времени работы приюта для собак и адрес приюта
    INFO_WORK_SCHEDULE_CATS("/workshedulecats"),// Информация о времени работы приюта для кошек и адрес приюта
    CONTACT_SECURITY_CATS("/contactsecuritycats"), //Контактные данные охраны для оформления пропуска в приют для кошек
    CONTACT_SECURITY_DOGS("/contactsecuritydogs"), //Контактные данные охраны для оформления пропуска в приют для собак

    CHECK("/check"),

    GOOD_REPORT_DOG("/goodReportDog"),
    BAD_REPORT_DOG("/badReportDog"),
    ADD_14_DAYS_DOG("/add14daysDog"),
    ADD_30_DAYS_DOG("/add30daysDog"),
    FAILED_PROBATION_DOG("failedDog"),

    RECOMMENDATIONS_SAFETY_CATS("/infosafetycats"), //Правила безопасности в приюте для кошек
    RECOMMENDATIONS_SAFETY_DOGS("/infosafetydogs"),//Правила безопасности в приюте для собак
    CREATE_DOG_VOLUNTEER("/createDogVolunteer"), //Create dogs shelter volunteer command name
    CREATE_CAT_VOLUNTEER("/createCatVolunteer"), //Create cats shelter volunteer command name
    CREATE_USER_DOG("/createUserDog"), // Create user dog command name
    CREATE_USER_CAT("/createUserCat"), // Create user cat command name
    BACK_TO_MENU("/backtomenu"); // Кнопка выхода в предыдущее меню

    private final String commandName;
}
