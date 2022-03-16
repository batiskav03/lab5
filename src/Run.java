
import tools.CollectionManager;
import tools.CommandManager;
import tools.JsonProcessing;

import java.io.IOException;
import java.util.logging.*;


/**
 * @author Калабухов Максим
 */

public class Run {
    public static void main(String[] args) throws IOException {

        Handler FileHandler = new FileHandler("log.log");
        JsonProcessing.log.setUseParentHandlers(false);
        JsonProcessing.log.addHandler(FileHandler);
        JsonProcessing.log.info("Program is running.");
        CommandManager manage = new CommandManager(new CollectionManager());
        manage.interactiveMod();
        JsonProcessing.log.info("Program successful complete.");






    }
}