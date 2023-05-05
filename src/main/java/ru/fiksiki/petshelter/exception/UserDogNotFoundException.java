package ru.fiksiki.petshelter.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserDogNotFoundException extends NullPointerException {
    public UserDogNotFoundException() {
        log.error("Can not read UserDog from DataBase");
    }
}
