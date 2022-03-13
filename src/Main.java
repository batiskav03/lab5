import data.Color;
import data.Dragon;
import tools.CollectionManager;
import tools.CommandManager;
import tools.JsonProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        CommandManager manage = new CommandManager(new CollectionManager());

        manage.interactiveMod();

    }
}