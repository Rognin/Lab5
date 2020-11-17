package Commands;

import main.*;
import server.ServerTCP;

/**add an element to the collection*/
public class Add extends Command{
    @Override
    public void onCall(String args) {

        LabWorkUserInputReader ir = new LabWorkUserInputReader();
        LabWork lw = ir.getUserInput();
        Main.additionalOutputToServer=lw;
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
