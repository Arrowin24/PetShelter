package ru.fiksiki.petshelter.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class UnknownCommandNotFoundException extends NullPointerException{
    private final  String message = "UnknownCommand.java is not found. Check existence or component annotation.";
    public UnknownCommandNotFoundException() {
        super();
        log.error(message);
    }
}
