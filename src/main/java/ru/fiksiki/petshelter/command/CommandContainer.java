package ru.fiksiki.petshelter.command;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CommandContainer {
    private final Map<String, Command> commandMap;


    public CommandContainer(List<Command> commands) {
        commandMap = commands.stream().collect(
                Collectors.toUnmodifiableMap(command -> command.getName().getCommandName(), command -> command,
                                             (o1, o2) -> o1));
    }

    public CommandBehavior retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, null);
    }
}
