package me.pack;

import me.pack.command.Command;
import me.pack.command.CommandService;
import me.pack.command.line.*;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static boolean isRunning = true;

    public static void main(String[] args) {
        System.out.println("Hello here is task 3!");
        CommandService commandService = new CommandService();
        commandService.registerCommand(new NextCommand());
        commandService.registerCommand(new CleanCommand());
        commandService.registerCommand(new ListCommand());
        commandService.registerCommand(new EndCommand());
        commandService.registerCommand(new HelpCommand(commandService));

        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            String commandName = scanner.nextLine();
            Optional<Command> command = commandService.getCommand(commandName);

            if (command.isPresent()) {
                command.get().execute();
            }else{
                System.out.println(String.format("%sUnknown command. %s%s"
                        ,Constants.COLOR_ANSI_CYAN, commandName, Constants.COLOR_ANSI_RESET));
            }
        }
    }
}