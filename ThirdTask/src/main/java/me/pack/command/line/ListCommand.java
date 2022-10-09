package me.pack.command.line;

import me.pack.Constants;
import me.pack.command.Command;

public class ListCommand extends Command {
    public ListCommand() {
        super(Constants.COMMAND_LIST);
    }
    @Override
    public void execute() {
        kanyeManager.showKanyeQuoteList();
    }
}
