package tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import data.Dragon;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Класс для работы с файлами формата .json
 */
public class JsonProcessing {
    /**
     * Логи
     */
    public static Logger log = Logger.getGlobal();
    /**
    / Свойство - переменная окружения
    */
    static String env = System.getenv("env");
    /**
     * Метод - сохраняет коллекцию в файл формата .json
     * @param collection Map Коллекция, которую сохраняем
     */
    public void saveCollection(Map collection) throws IOException {

        Gson json = new GsonBuilder().setPrettyPrinting().create();
        String gson = json.toJson(collection);
        FileOutputStream save = new FileOutputStream("JSON_FILE.json");
        save.write(gson.getBytes());
    }

    /**
     * Метод - преобразует файл формата .json в связную карту
     * @return Связную карту
     */
    static public LinkedHashMap<Integer,Dragon> readFile() throws IOException {
        Gson gson = new Gson();
        Type entityType = new TypeToken<LinkedHashMap<Integer, Dragon>>(){}.getType();
        FileReader read = new FileReader("JSON_FILE.json");
        return gson.fromJson(read , entityType);
    }
}
