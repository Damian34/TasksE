package me.pack.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandService {
    private final List<Command> commandsList;
    public CommandService() {
        this.commandsList = new ArrayList<>();
    }
    public List<Command> getCommandsList(){return this.commandsList;}
    public void registerCommand(Command command) {
        this.commandsList.add(command);
    }
    public Optional<Command> getCommand(String name) {
        return this.commandsList.stream()
                .filter(command -> command.getName().equals(name))
                .findFirst();
    }
}
