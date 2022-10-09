package me.pack.command.line;

import me.pack.Constants;
import me.pack.Main;
import me.pack.command.Command;

public class EndCommand extends Command {
    public EndCommand() {
        super(Constants.COMMAND_END);
    }
    @Override
    public void execute() {
        Main.isRunning = false;
    }
}
