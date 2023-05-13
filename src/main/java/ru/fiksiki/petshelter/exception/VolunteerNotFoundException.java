package ru.fiksiki.petshelter.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class VolunteerNotFoundException extends NullPointerException{
    public VolunteerNotFoundException() {
        log.error("Can not read Volunteer from DataBase");
    }
}
