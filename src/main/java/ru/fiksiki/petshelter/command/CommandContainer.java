package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;
import ru.fiksiki.petshelter.exception.UnknownCommandNotFoundException;
//import ru.fiksiki.petshelter.exception.UnknownCommandNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CommandContainer {
    private final Map<String, Command> commandMap;

    private final Command unknownCommand;


    public CommandContainer(List<Command> commands) {
        commandMap = commands.stream()
                             .filter(command -> !command.getName().equals(CommandName.UNKNOWN))
                             .collect(
                                     Collectors.toUnmodifiableMap(command -> command.getName().getCommandName(), command -> command,
                                                                  (o1, o2) -> o1));
        unknownCommand = commands.stream().filter(command -> command.getName().equals(CommandName.UNKNOWN)).findFirst().orElseThrow(
                UnknownCommandNotFoundException::new);
    }

    public CommandBehavior retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
