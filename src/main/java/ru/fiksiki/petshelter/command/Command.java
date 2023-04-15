package ru.fiksiki.petshelter.command;

public abstract class Command implements  CommandBehavior{
    private final CommandName name;

    public Command(CommandName name) {
        this.name = name;
    }

    public CommandName getName() {
        return name;
    }
}
