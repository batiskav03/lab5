import data.Color;
import data.Dragon;
import tools.CollectionManager;
import tools.CommandManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CommandManager manage = new CommandManager(new CollectionManager());
        manage.interactiveMod();

    }
}
