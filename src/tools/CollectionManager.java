package tools;

import data.Color;
import data.Dragon;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

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
        Dragon a = new Dragon(asker.askName(),asker.askCoordinates(), new Date(), asker.askAge(), asker.askColor(), asker.askDragonType(), asker.askDragonCharacter(), asker.askDragonHead());
        dragonsCollection.put(key, a);
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
    public void MaxByCreatinDateCommand() {
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






}
