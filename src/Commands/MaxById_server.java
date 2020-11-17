package Commands;

import main.LabWork;
import main.LabworkByIdComparator;
import main.Main;
import server.ServerTCP;

import java.io.IOException;

/**
 * print the information about the element in the main collection with the greatest id value
 */
public class MaxById_server extends Command_server {
    @Override
    public void onCall(String args) throws IOException {
        ServerTCP.answer = ServerTCP.getSet().stream().max(new LabworkByIdComparator()).get().toString();
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
