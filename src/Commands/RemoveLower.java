package Commands;

import main.*;
import server.ServerTCP;

import java.io.IOException;

/**remove all elements with a value less than that of the given one*/
public class RemoveLower extends Command {
    @Override
    public void onCall(String args) throws IOException {
        LabWorkUserInputReader ir = new LabWorkUserInputReader();
        LabWork lw = ir.getUserInput();

        Main.additionalOutputToServer = lw;
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
