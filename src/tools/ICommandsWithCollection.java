package tools;

import data.Color;

public interface ICommandsWithCollection {
    void insertNullCommand(Integer key);
    void updateIDCommand(Integer id);
    void removeKeyCommand(Integer key);
    void clearCommand();
    void removeGreaterKeyCommand(Integer key);
    void removeLowerKeyCommand(Integer key);
    void maxByCreationDateCommand();
    void filteredByColorCommand(Color color);
    void printAscendingCommand();


}
