package tools;

import data.Dragon;

public interface ICommandsWithCollection {
    void insertNullCommand(Dragon element);
    void updateIDCommand(Dragon element);
    void removeKeyNullCommand(int id);
    void clearCommand();
    void removeGreaterKeyCommand();
    void removeLowerKeyCommand();
    void maxByCreationDateCommand();
    void filterByColor();
    void printAscending();
}
