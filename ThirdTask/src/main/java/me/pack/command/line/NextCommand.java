package me.pack.command.line;

import me.pack.Constants;
import me.pack.command.Command;

public class NextCommand extends Command {
    public NextCommand() {
        super(Constants.COMMAND_NEXT);
    }
    @Override
    public void execute() {
        kanyeManager.nextKanyeQuote();
    }
}
