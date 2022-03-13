package tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import data.Dragon;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class JsonProcessing {
    public void saveCollection(Map collection) throws IOException {
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        String gson = json.toJson(collection);
        FileOutputStream save = new FileOutputStream("JSON_FILE.json");
        save.write(gson.getBytes());
    }
    static public LinkedHashMap<Integer,Dragon> readFile() throws IOException {
        Gson gson = new Gson();
        Type entityType = new TypeToken<LinkedHashMap<Integer, Dragon>>(){}.getType();
        FileReader read = new FileReader("/Users/batiskav03/IdeaProjects/lab5/JSON_FILE.json");
        LinkedHashMap<Integer,Dragon> result = gson.fromJson(read , entityType);
        return result;
    }
}
