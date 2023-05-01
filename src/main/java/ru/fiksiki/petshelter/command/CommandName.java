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
    GET_VOLUNTEERS("/getVolunteers"), // Позвать волонтера
    INFO_CATS("/infocats"), //Информация о приюте кошек
    INFO_DOGS("/infodogs"), //Информация о приюте собак
    INFO_WORK_SCHEDULE_DOGS("/worksheduledogs"), // Информация о времени работы приюта для собак и адрес приюта
    INFO_WORK_SCHEDULE_CATS("/workshedulecats"),// Информация о времени работы приюта для кошек и адрес приюта
    CONTACT_SECURITY_CATS("/contactsecuritycats"), //Контактные данные охраны для оформления пропуска в приют для кошек
    CONTACT_SECURITY_DOGS("/contactsecuritydogs"), //Контактные данные охраны для оформления пропуска в приют для собак
    RECOMMENDATIONS_SAFETY_CATS("/infosafetycats"), //Правила безопасности в приюте для кошек
    RECOMMENDATIONS_SAFETY_DOGS("/infosafetydogs"),//Правила безопасности в приюте для собак
    BACK_TO_MENU("/backtomenu"), // Кнопка выхода в предыдущее меню
    RECOMMENDATIONS_CATS("/recomendationscats"), //Кнопка с рекомендациями для потенциальных хозяев кошки
    RECOMMENDATIONS_DOGS("/recommendationsdogs"), //Кнопка с рекомендациями для потенциальных хозяев собаки
    CATS_RULES("/catsrules"), //Кнопка с правилами знакомства с кошкой
    DOGS_RULES("/dogssrules"), //Кнопка с правилами знакомства с кошкой
    LIST_DOCUMENTATIONS_DOGS("/listdocumentationdogs"), //Кнопка с документами необходимыми для взятия собаки из приюта
    LIST_DOCUMENTATIONS_CATS("/listdocumentationcats"), //Кнопка с документами необходимыми для взятия кошки из приюта
    TRANSPORTATION_DOGS("/transportationdogs"),//Кнопка с рекомендациями по транспортировке собаки
    TRANSPORTATION_CATS("/transportationcats"),//Кнопка с рекомендациями по транспортировке кошки
    HOME_IMPROVEMENT_PUPPIES("/homepuppies"), // Кнопка с рекомендациями по обустройству дома для щенка
    HOME_IMPROVEMENT_KITTEN("/homekitten"), // Кнопка с рекомендациями по обустройству дома для котенка
    HOME_IMPROVEMENT_DOGS("/homedogs"), // Кнопка с рекомендациями по обустройству дома для взрослой собаки
    HOME_IMPROVEMENT_CATS("/homecats"), // Кнопка с рекомендациями по обустройству дома для взрослой кошки
    HOME_IMPROVEMENT_DISABLED_DOGS("/homedisabledgogs"), // Кнопка с рекомендациями по обустройству дома для собаки с ограниченными возможностями
    HOME_IMPROVEMENT_DISABLED_CATS("/homedisabledcats"), // Кнопка с рекомендациями по обустройству дома для кошки с ограниченными возможностями
    REASONS_FOR_REFUSAL_DOGS("/reasonsforrefusaldogs"), //Кнопка с правилами отказа от взятия собаки из приюта
    REASONS_FOR_REFUSAL_CATS("/reasonsforrefusalcats"); //Кнопка с правилами отказа от взятия кошки из приюта


    private final String commandName;
}
