package commands;

import main.Main;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**execute a script from a file*/
public class ExecuteScript extends CommandWithArgs {

    /**the parameter*/
    String args = "";

    /**the name of the file with a script*/
    String fileName = "";

    @Override
    public void onCall(String args) throws IOException {
        try {
            getArgs(args);
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNext()) {
                String input = sc.nextLine();
                if (input == null || input.isEmpty()) break;
                Main.executeNextCommand(input);
            }
        }catch (IOException e){
            System.out.println("this file doesn't exist. if you included the extension please try again without it");
        }
    }

    @Override
    public void getArgs(String args) {
        super.getArgs(args);
        try {
            fileName = super.args;
        }catch (InputMismatchException e){
            System.out.println("please enter the name of the file without the extension");
            getArgs(Main.sc.nextLine());
        }
    }

    @Override
    public String getHelp() {
        return super.getHelp();
    }
}
