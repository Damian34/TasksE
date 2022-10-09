package me.pack.command;

import me.pack.KanyeManager;

public abstract class Command {
    private final String name;
    protected final static KanyeManager kanyeManager;

    static{
        kanyeManager = new KanyeManager();
    }
    public Command(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract void execute();
}
