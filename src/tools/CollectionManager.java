package tools;

import data.Color;
import data.Dragon;

import java.io.*;
import java.util.*;

/**
 * Класс - для работы с коллекцией
 *
 * @author Калабухов Максим
 */
public class CollectionManager implements ICommandsWithCollection,ICommandsWithoutCollection,ICommandsWithFileAndCollection {
    /**
     * Свойство - Связная карта хранящая объекты класса dragon
     */
    private final LinkedHashMap<Integer, Dragon> dragonsCollection;
    /**
     * Свойство - Карта, хранящая описание всех команд
     */
    private final HashMap<String, String> helpCommands;
    /**
     * Свойство - Связный список, хранящий историю
     */
    private final LinkedList<String> history = new LinkedList<>();
    /**
     * Свойство - Спрашивает свойства объекта Dragon
     */
    private final Asker asker = new Asker(new Scanner(System.in));
    /**
     * Свойство - ID объектов
     */
    private static int idCounter;
    /**
     * Свойство - Дата инициализации коллекции
     */
    private final Date date = new Date();


    /**
     * Конструктор без параметров
     *
     * @throws IOException the io exception
     */
    public CollectionManager() throws IOException {
        dragonsCollection = JsonProcessing.readFile();
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
        idCounter = JsonProcessing.readFile().size();
    }

    /**
     * Method - get next ID
     *
     * @return the integer
     */
    public static Integer getRandomID(){
        return idCounter++;
    }

    /**
     * Method - outputs collection
     */
    @Override
    public void showCommand() {
        System.out.println("Date collection: " + date);
        List<Dragon> needSort = new ArrayList<>(dragonsCollection.values());
        Collections.sort(needSort);

        for (Dragon i : needSort) {
            System.out.println(i);
        }

        if (history.size() == 16) {
            history.removeLast();
        }
        history.addFirst("show");
        System.out.println("------------------------");

    }

    /**
     * Method - outputs information about commands
     */
    @Override
    public void helpCommand() {
        for (Map.Entry<String, String> entry : helpCommands.entrySet()) {
            System.out.println(entry);
        }
        if (history.size() == 16) {
            history.removeLast();
        }
        history.addFirst("help");
        System.out.println("------------------------");
    }

    /**
     * Метод - добавляет элемент в коллекцию по ключу
     *
     * @param key Integer ключ
     */
    @Override
    public void insertNullCommand(Integer key){
        try {
            Dragon a = new Dragon(asker.askName(), asker.askCoordinates(), new Date(), asker.askAge(), asker.askColor(), asker.askDragonType(), asker.askDragonCharacter(), asker.askDragonHead());
            dragonsCollection.put(key, a);
        } catch (NoSuchElementException e) {
            System.out.println("Collection is empty");
            JsonProcessing.log.warning("NoSuchElementException!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid value");
            JsonProcessing.log.warning("NumberFormatExeption!");
        }
        if (history.size() == 16) {
            history.removeLast();
        }
        history.addFirst("insert null");


    }

    /**
     * Метод - Выводит информацию о коллекции
     */
    @Override
    public void infoCommand(){
        System.out.println("Count of element in collection := " + dragonsCollection.size());
        if (history.size() == 16) {
            history.removeLast();
        }
        history.addFirst("info");
        System.out.println("------------------------");

    }

    /**
     * Метод - Обновляет элемент по полю id
     *
     * @param id Integer
     */
    @Override
    public void updateIDCommand(Integer id) { // ** need Exception
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

    /**
     * Метод - удаляет элемент из коллекции по заданному ключу
     *
     * @param key Integer ключ
     */
    @Override
    public void removeKeyCommand(Integer key){
        dragonsCollection.remove(key);
        if (history.size() == 16) {
            history.removeLast();
        }
        history.addFirst("remove_key");
        System.out.println("------------------------");
    }

    /**
     * Метод - Очищает коллекцию
     */
    @Override
    public void clearCommand(){
        dragonsCollection.clear();
        if (history.size() == 16) {
            history.removeLast();
        }
        history.addFirst("clear");
        System.out.println("------------------------");
    }

    /**
     * Метод - выводит последние 5 команд
     */
    @Override
    public void historyCommand(){
        int i = 0;
        System.out.println("The last five commands:");
        for (String item : history){
            i++;
            System.out.println(i + " - " +item);
        }
        System.out.println("------------------------");
    }

    /**
     * Метод - удаляет все элементы, превышающие данный ключ
     *
     * @param key Integer
     */
    @Override
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

    /**
     * Метод - Выводит все элементы коллекции с заданным в параметре цветом
     *
     * @param color Color цвет дракона
     */
    @Override
    public void filteredByColorCommand(Color color){
        for (Map.Entry<Integer, Dragon> entry : dragonsCollection.entrySet()) {
            if (entry.getValue().getColor().equals(color)) {
                System.out.println(entry);

            }
        }
        System.out.println("------------------------");
    }

    /**
     * Метод - удаляет все элементы коллекции, ключ которых меньше заданного
     *
     * @param key Integer
     */
    @Override
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

    /**
     * Метод - выводит элемент, который добавлен позже всех
     */
    @Override
    public void maxByCreationDateCommand() {
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

    /**
     * Метод - выводит элементы коллекции в порядке возрастания
     */
    @Override
    public void printAscendingCommand() {
        Map<Integer, Dragon> treeMap = new TreeMap<>(dragonsCollection);
        for (Map.Entry<Integer, Dragon> entry : treeMap.entrySet()) {
            System.out.println(entry);
        }
    }

    /**
     * Метод - сохраняет коллекцию в файл
     */
    @Override
    public void saveCommand()  {
        JsonProcessing json = new JsonProcessing();
        try {
            json.saveCollection(dragonsCollection);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            JsonProcessing.log.warning("IOException!");
        }
    }

    /**
     * Метод - запускает выполнение файла с заданным именем
     *
     * @param file_name String имя_файла
     */
    @Override
    public void executeScriptCommand(String file_name) {
        String command;
        String[] finalCommand;
        try{
            System.out.println(file_name + " reading has started");
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
                        updateIDCommand(Integer.parseInt(finalCommand[1]));
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
                        maxByCreationDateCommand();
                        break;
                    case "exit":
                        System.out.println("Выход выполнен успешно");
                        break;
                    case "save":
                        saveCommand();
                        break;
                    case "as":
                        printAscendingCommand();
                        break;
                    default:
                        System.out.println("Command not found. Enter \"help\". ");      //эксепшен с реверсивным вызовом файла.

            }
            command = inputStreamReader.readLine();
        }


    } catch (FileNotFoundException e) {
        System.out.println("File doesn't exist");
        JsonProcessing.log.warning("FileNotFoundException");
    } catch (IOException e) {
            System.out.println("Reading is not possible");
            JsonProcessing.log.warning("IOException!");
        }
    }


}
