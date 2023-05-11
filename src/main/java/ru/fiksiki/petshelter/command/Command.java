package ru.fiksiki.petshelter.command;

/**
 * The Command class is an abstract class that defines the basic structure of a command object.
 * It implements the CommandBehavior interface to ensure that all subclasses have the required methods.
 */
public abstract class Command implements CommandBehavior {
    private final CommandName name;

    /**
     * Constructs a Command object with the given name.
     *
     * @param name A CommandName object representing the name of the command.
     */
    public Command(CommandName name) {
        this.name = name;
    }

    /**
     * Returns the name of the command.
     *
     * @return A CommandName object representing the name of the command.
     */
    public CommandName getName() {
        return name;
    }
}
