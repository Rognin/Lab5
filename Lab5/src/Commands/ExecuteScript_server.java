package Commands;

import main.Main;

import java.io.IOException;
import java.util.InputMismatchException;

/**execute a script from a file*/
public class ExecuteScript_server extends CommandWithArgs_server {

    /**the parameter*/
    String args = "";

    /**the name of the file with a script*/
    String fileName = "";

    @Override
    public void onCall(String args) throws IOException {
        }

    @Override
    public void getArgs(String args) {
        super.getArgs(args);
        try {
            fileName = super.args;
        }catch (InputMismatchException e){
            System.out.println("please enter the name of the file without the extension");
            getArgs(Main.scanner.nextLine());
        }
    }

    @Override
    public String getHelp() {
        return super.getHelp();
    }
}
