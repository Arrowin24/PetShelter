package ru.fiksiki.petshelter.command;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Enum contains commands names. Command use names to link with telegram bot API
 */
@Getter
@AllArgsConstructor
public enum CommandName {
    START("/start"), //������� ������ ���� ������ ������ � �����������
    HELP("/help"), // ������� ������ ������ ������

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
    FAILED_PROBATION_DOG("failedDog"),

    RECOMMENDATIONS_SAFETY_CATS("/infosafetycats"), //������� ������������ � ������ ��� �����
    RECOMMENDATIONS_SAFETY_DOGS("/infosafetydogs"),//������� ������������ � ������ ��� �����
    CREATE_DOG_VOLUNTEER("/createDogVolunteer"), //Create dogs shelter volunteer command name
    CREATE_CAT_VOLUNTEER("/createCatVolunteer"), //Create cats shelter volunteer command name
    CREATE_USER_DOG("/createUserDog"), // Create user dog command name
    CREATE_USER_CAT("/createUserCat"), // Create user cat command name
    BACK_TO_MENU("/backtomenu"); // ������ ������ � ���������� ����

    private final String commandName;
}
