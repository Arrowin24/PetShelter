package ru.fiksiki.petshelter.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class AdopterNotFoundException extends NullPointerException{
    public AdopterNotFoundException() {
        log.error("Can not read Adopter from DataBase");
    }
}
