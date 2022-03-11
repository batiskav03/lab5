package tools;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ICommandsWithFileAndCollection {
    void saveCommand() throws IOException;
    void executeScriptCommand(String file_name);
}
