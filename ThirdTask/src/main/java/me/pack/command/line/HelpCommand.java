package me.pack.command.line;

import me.pack.Constants;
import me.pack.command.Command;
import me.pack.command.CommandService;

public class HelpCommand extends Command {
    private CommandService commandService;
    public HelpCommand(CommandService commandService) {
        super(Constants.COMMAND_HELP);
        this.commandService = commandService;
    }
    @Override
    public void execute() {
        this.commandService.getCommandsList().stream()
                .filter(command->!command.getName().equals(Constants.COMMAND_HELP))
                .forEach(command-> System.out.println(command.getName()));
    }
}
