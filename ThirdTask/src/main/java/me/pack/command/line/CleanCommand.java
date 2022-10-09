package me.pack.command.line;

import me.pack.Constants;
import me.pack.command.Command;

public class CleanCommand extends Command {
    public CleanCommand() {
        super(Constants.COMMAND_CLEAN);
    }
    @Override
    public void execute() {
        kanyeManager.cleanKanyeQuoteList();
    }
}
