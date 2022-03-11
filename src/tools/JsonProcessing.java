package tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.Dragon;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonProcessing {
    public void saveCollection(Map collection) throws IOException {
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        String gson = json.toJson(collection);
        FileOutputStream save = new FileOutputStream("JSON_FILE.json");
        save.write(gson.getBytes());
    }
}
