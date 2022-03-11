package tools;

import data.Color;


import java.util.Scanner;

public class CommandManager {
    private final CollectionManager manager;
    private String userCommand = "";
    private String[] finalCommand;




    public CommandManager(CollectionManager manager) {
        this.manager = manager;

    }
    public void interactiveMod(){
        Scanner scansmthg = new Scanner(System.in);
        while (!userCommand.equals("exit")) {
            System.out.print("Enter the command:");
            userCommand = scansmthg.nextLine();
            finalCommand = userCommand.trim().split(" ",2);
            commandManager();

        }
    }

    public void commandManager() {
        switch (finalCommand[0]) {
            case "show":
                manager.showCommand();
                break;
            case "help":
                manager.helpCommand();
                break;
            case "info":
                manager.infoCommand();
                break;
            case "clear":
                manager.clearCommand();
                break;
            case "history":
                manager.historyCommand();
                break;
            case "insert":
                manager.insertNullCommand(Integer.parseInt(finalCommand[1]));
                break;
            case "update":
                manager.updateIDCommand(Integer.parseInt(finalCommand[1]));
                break;
            case "remove":
                manager.removeKeyCommand(Integer.parseInt(finalCommand[1]));
                break;
            case "rmv_greater":
                manager.removeGreaterKeyCommand(Integer.parseInt(finalCommand[1]));
                break;
            case "rmv_lower":
                manager.removeLowerKeyCommand(Integer.parseInt(finalCommand[1]));
                break;
            case "filter_color":
                manager.filteredByColorCommand(Color.valueOf(finalCommand[0]));
                break;
            case "max_date":
                manager.maxByCreationDateCommand();
                break;
            case "exit":
                System.out.println("Выход выполнен успешно");
                break;
            case "execute_script":
                manager.executeScriptCommand(finalCommand[1]);
            case "print_ascending":
                manager.printAscendingCommand();
                break;
            case "save":
                manager.saveCommand();
                break;
            default:
                System.out.println("Comannd not found. Enter \"help\". ");
        }

    }

}
