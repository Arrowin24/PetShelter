package ru.fiksiki.petshelter.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserCatNotFoundException extends NullPointerException {
    public UserCatNotFoundException() {
        log.error("Can not read UserCat from DataBase");
    }
}
