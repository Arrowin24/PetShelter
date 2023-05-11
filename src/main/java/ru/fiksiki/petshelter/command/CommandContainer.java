package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import ru.fiksiki.petshelter.exception.UnknownCommandNotFoundException;
//import ru.fiksiki.petshelter.exception.UnknownCommandNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A container for commands in the chatbot.
 * This class maps command names to their corresponding command objects
 * and provides a fallback command for unknown commands.
 */
@Component
public class CommandContainer {
    /**
     * A map representing the commands available in the application.
     */
    private final Map<String, Command> commandMap;
    /**
     * The fallback command for unknown commands.
     */
    private final Command unknownCommand;

    /**
     * Constructs a CommandContainer object with a list of commands.
     *
     * @param commands A list of Command objects representing the available commands.
     */
    public CommandContainer(List<Command> commands) {
        commandMap = commands.stream().filter(command -> !command.getName().equals(CommandName.UNKNOWN)).collect(
                Collectors.toUnmodifiableMap(command -> command.getName().getCommandName(), command -> command,
                                             (o1, o2) -> o1));
        unknownCommand = commands.stream().filter(command -> command.getName().equals(CommandName.UNKNOWN)).findFirst()
                                 .orElseThrow(UnknownCommandNotFoundException::new);
    }

    /**
     * Retrieves the command object corresponding to the given command identifier.
     * If the command identifier is not found in the command map, returns the unknown command object instead.
     *
     * @param commandIdentifier A String representing the name of the command.
     * @return A CommandBehavior object representing the requested command.
     */
    public CommandBehavior retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
