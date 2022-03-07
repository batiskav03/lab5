package tools;

import data.Color;
import data.Dragon;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class CollectionManager {
    private LinkedHashMap<Integer, Dragon> dragonsCollection;
    private HashMap<String, String> helpCommands;
    private LinkedList<String> history = new LinkedList<>();
    private Asker asker = new Asker(new Scanner(System.in));
    private static AtomicInteger idCounter = new AtomicInteger();


    public CollectionManager() {
        dragonsCollection = new LinkedHashMap<>();
        helpCommands = new HashMap<>();
        helpCommands.put("help :", "Список команд");
        helpCommands.put("info :", "Информация о коллекции");
        helpCommands.put("show :", "Все элементы в коллекции");
        helpCommands.put("insert {key} :", "Добавить новый элемент с заданным ключ");
        helpCommands.put("update {id} :", "Обновить значение");
        helpCommands.put("remove {key} :", "Удалить элемент из коллекции по ключу");
        helpCommands.put("clear :", "Очистить коллекцию");
        helpCommands.put("save :", "Сохранить коллекцию в файл");
        helpCommands.put("execute_script file_name :", "Считать и исполнить скрипт из указанного файла");
        helpCommands.put("exit :", "Завершить программу (без сохранения в файл)");
        helpCommands.put("history :", "Вывести последние 15 команд (без их аргументов)");
        helpCommands.put("rmv_greater {key} :", "Удалить из коллекции все элементы, ключ которых превышает заданный");
        helpCommands.put("rmv_lower {key} :", "Удалить из коллекции все элементы, ключ которых меньше, чем заданный");
        helpCommands.put("max_date :", " Вывести любой объект из коллекции, значение поля creationDate которого является максимальным");
        helpCommands.put("filter_color {color} :", "Вывести элементы, значение поля color которых равно заданному");
        helpCommands.put("print_ascending", "Вывести элементы коллекции в порядке возрастания");
    }

    public static Integer getRandomID(){
        return idCounter.getAndIncrement();
    }

    public void showCommand() {
        dragonsCollection.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(Map.Entry::getValue);

        for (Map.Entry<Integer, Dragon> entry : dragonsCollection.entrySet()) {
            System.out.println(entry.toString());
        }
        if (history.size() == 16) {
            history.removeLast();
            history.addFirst("show");
        }
        else {
            history.addFirst("show");
        }
        System.out.println("------------------------");

    }

    public void helpCommand() {
        for (Map.Entry<String, String> entry : helpCommands.entrySet()) {
            System.out.println(entry);
        }
        if (history.size() == 16) {
            history.removeLast();
            history.addFirst("help");
        }
        else {
            history.addFirst("help");
        }
        System.out.println("------------------------");
    }

    public void insertNullCommand(Integer key){
        try {
            Dragon a = new Dragon(asker.askName(), asker.askCoordinates(), new Date(), asker.askAge(), asker.askColor(), asker.askDragonType(), asker.askDragonCharacter(), asker.askDragonHead());
            dragonsCollection.put(key, a);
        } catch (NoSuchElementException e) {
            System.out.println("Collection is empty");
        } catch (NumberFormatException e) {
            System.out.println("Invalid value");
        }
        if (history.size() == 16) {
            history.removeLast();
            history.addFirst("insert null");
        }
        else {
            history.addFirst("insert null");
        }


    }

    public void infoCommand(){
        System.out.println("Count of element in collection := " + dragonsCollection.size());
        if (history.size() == 16) {
            history.removeLast();
            history.addFirst("info");
        }
        else {
            history.addFirst("info");
        }
        System.out.println("------------------------");
                                                                              // ** need update, cause this is not all information
    }

    public void uptadeIDCommand(Integer id) { // ** need Exception
        for (Map.Entry<Integer, Dragon> entry : dragonsCollection.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                System.out.println("Update element:");
                dragonsCollection.put(entry.getKey(),new Dragon(asker.askName(),asker.askCoordinates(), new Date(), asker.askAge(), asker.askColor(), asker.askDragonType(), asker.askDragonCharacter(), asker.askDragonHead()));

            }
        }

        if (history.size() == 16) {
            history.removeLast();
            history.addFirst("update_id ");
        }
        else {
            history.addFirst("update_id");
        }

        System.out.println("------------------------");

    }

    public void removeKeyCommand(Integer key){
        dragonsCollection.remove(key);
        if (history.size() == 16) {
            history.removeLast();
            history.addFirst("remove_key");
        }
        else {
            history.addFirst("remove_key");
        }
        System.out.println("------------------------");
    }

    public void clearCommand(){
        dragonsCollection.clear();
        if (history.size() == 16) {
            history.removeLast();
            history.addFirst("clear");
        }
        else {
            history.addFirst("clear");
        }
        System.out.println("------------------------");
    }

    public void historyCommand(){
        int i = 0;
        System.out.println("The last five commands:");
        for (String item : history){
            i++;
            System.out.println(i + " - " +item);
        }
        System.out.println("------------------------");
    }

    public void removeGreaterKeyCommand(Integer key){
        Iterator<Map.Entry<Integer,Dragon>> i = dragonsCollection.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<Integer, Dragon> entry = i.next();
            if(key < entry.getKey()) {
                i.remove();
            }
        }
        System.out.println("------------------------");
    }

    public void filteredByColorCommand(Color color){
        for (Map.Entry<Integer, Dragon> entry : dragonsCollection.entrySet()) {
            if (entry.getValue().getColor().equals(color)) {
                System.out.println(entry.toString());

            }
        }
        System.out.println("------------------------");
    }

    public void removeLowerKeyCommand(Integer key) {
        Iterator<Map.Entry<Integer,Dragon>> i = dragonsCollection.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<Integer, Dragon> entry = i.next();
            if(key > entry.getKey()) {
                i.remove();
            }
        }
        System.out.println("------------------------");

    }

    public void MaxByCreationDateCommand() {
        long maxdatemls = 0;
        Integer key = null;
        for (Map.Entry<Integer, Dragon> entry : dragonsCollection.entrySet()) {
            if (entry.getValue().getCreationDate().getTime() > maxdatemls) {
                maxdatemls = entry.getValue().getCreationDate().getTime();
                key = entry.getKey();
            }
        }
        System.out.println(dragonsCollection.get(key));
        System.out.println("------------------------");
    }

    public void executeScriptCommand(String file_name) {
        String command;
        String[] finalCommand;
        try{
            System.out.println( file_name + "reading has started");
            BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(new FileInputStream(file_name)));
            command = inputStreamReader.readLine();
            while (command != null) {
                finalCommand = command.trim().split(" ",2);
                System.out.println("The command is being processed: " + finalCommand[0]);
                switch (finalCommand[0]) {
                    case "show":
                        showCommand();
                        break;
                    case "help":
                        helpCommand();
                        break;
                    case "info":
                        infoCommand();
                        break;
                    case "clear":
                        clearCommand();
                        break;
                    case "history":
                        historyCommand();
                        break;
                    case "insert":
                        insertNullCommand(Integer.parseInt(finalCommand[1]));
                        break;
                    case "update":
                        uptadeIDCommand(Integer.parseInt(finalCommand[1]));
                        break;
                    case "remove":
                        removeKeyCommand(Integer.parseInt(finalCommand[1]));
                        break;
                    case "rmv_greater":
                        removeGreaterKeyCommand(Integer.parseInt(finalCommand[1]));
                        break;
                    case "rmv_lower":
                        removeLowerKeyCommand(Integer.parseInt(finalCommand[1]));
                        break;
                    case "filter_color":
                        filteredByColorCommand(Color.valueOf(finalCommand[0]));
                        break;
                    case "max_date":
                        MaxByCreationDateCommand();
                        break;
                    case "exit":
                        System.out.println("Выход выполнен успешно");
                        break;
                    default:
                        System.out.println("Comannd not found. Enter \"help\". ");      // нужно сюда еще пару методов засунуть + эксепшен с реверсивным вызовом файла.

            }
            command = inputStreamReader.readLine();
        }


    } catch (FileNotFoundException e) {
        System.out.println("File doesn't exist");
    } catch (IOException e) {
            System.out.println("Reading is not possible");
        }
    }


}
