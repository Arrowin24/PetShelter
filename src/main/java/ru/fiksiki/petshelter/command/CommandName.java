package ru.fiksiki.petshelter.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommandName {
    START("/start"),
    HELP("/help");

    private final String commandName;
}
