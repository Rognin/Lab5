package Commands;

import main.Main;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

/**print the last 6 commands entered*/
public class History_server extends Command_server{
    @Override
    public void onCall(String args) throws IOException {
    }

    @Override
    public void getArgs(String args) {
        super.getArgs(args);
    }

    @Override
    public String getHelp() {
        return super.getHelp();
    }
}
