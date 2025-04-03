package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo instance;
    private List<String> commandHistory;
    private final int maxHistorySize = 10;

    private Undo() {
        commandHistory = new ArrayList<>();
    }

    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    public void addCommand(String command) {
        if (commandHistory.size() >= maxHistorySize) {
            commandHistory.remove(0);
        }
        commandHistory.add(command);
    }

    public String removeLastCommand() {
        if (commandHistory.isEmpty()) {
            return null;
        }
        return commandHistory.remove(commandHistory.size() - 1);
    }

    public void listCommands() {
        if (commandHistory.isEmpty()) {
            System.out.println("No commands in history.");
            return;
        }

        System.out.println("Command history:");
        for (int i = 0; i < commandHistory.size(); i++) {
            System.out.println((i + 1) + ": " + commandHistory.get(i));
        }
    }

    public void clearHistory() {
        commandHistory.clear();
    }
}