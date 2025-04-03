package org.example;

import org.example.entities.Undo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Undo undo = Undo.getInstance();

        System.out.println("------------------\n| COMMAND SYSTEM |\n------------------");
        System.out.println("Available commands:");
        System.out.println("  add <command> - Add a command to history");
        System.out.println("  undo - Remove the last command");
        System.out.println("  list - List all commands in history");
        System.out.println("  clear - Clear command history");
        System.out.println("  exit - Exit the program");

        boolean running = true;
        while (running) {
            System.out.print("\n> ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();

            switch (command) {
                case "add":
                    if (parts.length > 1 && !parts[1].trim().isEmpty()) {
                        String cmdToAdd = parts[1].trim();
                        undo.addCommand(cmdToAdd);
                        System.out.println("Added command: " + cmdToAdd);
                    } else {
                        System.out.println("Please specify a command to add.");
                    }
                    break;

                case "undo":
                    String removed = undo.removeLastCommand();
                    System.out.println(removed != null ?
                            "Undid command: " + removed : "No commands to undo.");
                    break;

                case "list":
                    undo.listCommands();
                    break;

                case "clear":
                    undo.clearHistory();
                    System.out.println("Command history cleared.");
                    break;

                case "exit":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid command. Try 'add', 'undo', 'list', 'clear', or 'exit'.");
            }
        }

        scanner.close();
        System.out.println("Program exited.");
    }
}
