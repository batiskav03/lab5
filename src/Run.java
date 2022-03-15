import org.apache.log4j.LogManager;
import org.apache.log4j.*;
import tools.CollectionManager;
import tools.CommandManager;

import java.io.IOException;

/**
 * @author Калабухов Максим
 */

public class Run {
    static public Logger logger = LogManager.getLogger(Run.class);
    public static void main(String[] args) throws IOException {

        CommandManager manage = new CommandManager(new CollectionManager());
        manage.interactiveMod();
        logger.info("Starting is complete!");

    }
}