package commands;

import main.Main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ExecuteScript extends Command {

    String fileName = "";

    @Override
    public void onCall(String args) throws IOException {
        getArgs(args);
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNext()) {
            String input = Main.readNextCommand();
            if (input.equals("exit"))
                break;
            if (input.equals(""))
                continue;
            Main.executeNextCommand(input);
        }
    }

    @Override
    public void getArgs(String args) {
        fileName = args;
    }

    @Override
    public String getHelp() {
        return super.getHelp();
    }
}
