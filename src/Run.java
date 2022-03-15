
import tools.CollectionManager;
import tools.CommandManager;

import java.io.IOException;
import java.util.logging.*;


/**
 * @author Калабухов Максим
 */

public class Run {
    private static Logger log = Logger.getLogger(Run.class.getName());
    public static void main(String[] args) throws IOException {
        Handler FileHandler = new FileHandler();
        log.setUseParentHandlers(false);
        log.addHandler(FileHandler);
        log.info("Running");
        CommandManager manage = new CommandManager(new CollectionManager());



        manage.interactiveMod();





    }
}