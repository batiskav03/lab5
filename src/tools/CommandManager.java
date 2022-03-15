package tools;

import data.Color;


import java.util.Scanner;

/**
 * Класс - реализовывающий пользовательский ввод
 * @author Калабухов Максим
 */
public class CommandManager {
    /**
     * Свойство - Класс выполняющий работу с коллекцией
     */
    private final CollectionManager manager;
    /**
     * Свойство - Введенные данные
     */
    private String userCommand = "";
    /**
     * Свойство - Массив содержащий команды разделенные пробелами
     */
    private String[] finalCommand;


    public CommandManager(CollectionManager manager) {
        this.manager = manager;

    }

    /**
     * Метод - вызывает интерактивный режим
     */
    public void interactiveMod(){
        Scanner scansmthg = new Scanner(System.in);
        while (!userCommand.equals("exit")) {
            System.out.print("Enter the command:");

            userCommand = scansmthg.nextLine();
            finalCommand = userCommand.trim().split(" ",2);
            commandManager();

        }
    }

    /**
     * Метод - определяющий соответствие введенной строки и команды
     *
     */
    public void commandManager() {
        try {
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
                    System.out.println("Have a nice day)");
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
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Need a numeric argument!");

        }

    }

}
