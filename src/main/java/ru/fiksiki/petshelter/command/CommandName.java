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
    DOGS("/dogs"), // ������� ������ ������ ��� �����
    CATS("/cats"), //������� ������ ������ ��� �����
    INFO_SHELTER("/getInfo"), // ������ ���������� � ������
    GET_PET_IS_SHELTER("/getPet"),//��� ����� �������� �� ������
    REPORT_DOG("/report_dog"), // �������� ����� � ������� ������
    REPORT_CAT("/report_cat"), // �������� ����� � ������� �����
    GET_DOG_VOLUNTEER("/getDogVolunteer"), // ������� ��������� �� ������ ��� �����
    GET_CAT_VOLUNTEER("/getCatVolunteer"), // ������� ��������� �� ������ ��� �����
    ACCEPT_DOG_USER_QUERY("/acDQ"), //������� ������ �� ������������. ����� ��� �����
    DECLINE_DOG_USER_QUERY("/dcDQ"),//��������� ������ �� ������������. ����� ��� �����
    ACCEPT_CAT_USER_QUERY("/acCQ"), //������� ������ �� ������������. ����� ��� �����
    DECLINE_CAT_USER_QUERY("/dcCQ"),//��������� ������ �� ������������. ����� ��� �����
    FINISH_TALK_DOG_USER("/finDog"), //��������� �������� � �������������. ����� ��� �����
    FINISH_TALK_CAT_USER("/finCat"), //��������� �������� � �������������. ����� ��� �����
    INFO_CATS("/infocats"), //���������� � ������ �����
    INFO_DOGS("/infodogs"), //���������� � ������ �����
    INFO_WORK_SCHEDULE_DOGS("/worksheduledogs"), // ���������� � ������� ������ ������ ��� ����� � ����� ������
    INFO_WORK_SCHEDULE_CATS("/workshedulecats"),// ���������� � ������� ������ ������ ��� ����� � ����� ������
    CONTACT_SECURITY_CATS("/contactsecuritycats"), //���������� ������ ������ ��� ���������� �������� � ����� ��� �����
    CONTACT_SECURITY_DOGS("/contactsecuritydogs"), //���������� ������ ������ ��� ���������� �������� � ����� ��� �����

    CHECK("/check"),

    GOOD_REPORT_DOG("/goodReportDog"),
    BAD_REPORT_DOG("/badReportDog"),
    ADD_14_DAYS_DOG("/add14daysDog"),
    ADD_30_DAYS_DOG("/add30daysDog"),
    FAILED_PROBATION_DOG("/failedDog"),
    GOOD_REPORT_CAT("/goodReportCat"),
    BAD_REPORT_CAT("/badReportCat"),
    ADD_14_DAYS_CAT("/add14daysCat"),
    ADD_30_DAYS_CAT("/add30daysCat"),
    FAILED_PROBATION_CAT("failedCat"),

    RECOMMENDATIONS_SAFETY_CATS("/infosafetycats"), //������� ������������ � ������ ��� �����
    RECOMMENDATIONS_SAFETY_DOGS("/infosafetydogs"),//������� ������������ � ������ ��� �����
    CREATE_DOG_VOLUNTEER("/createDogVolunteer"), //Create dogs shelter volunteer command name
    CREATE_CAT_VOLUNTEER("/createCatVolunteer"), //Create cats shelter volunteer command name
    CREATE_USER_DOG("/createUserDog"), // Create user dog command name
    CREATE_USER_CAT("/createUserCat"), // Create user cat command name
    BACK_TO_MENU_CAT("/backToMenuCat"), // ������ ������ � ���������� ����
    BACK_TO_MENU_DOG("/backToMenuDog"), // ������ ������ � ���������� ����
    GET_REPORT_IS_PET("/getReport"), // Прислать отчет о питомце
    GET_VOLUNTEERS("/getVolunteers"), // Позвать волонтера
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
