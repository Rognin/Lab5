package commands;

import main.*;

import java.io.IOException;

/**remove all elements with a value less than that of the given one*/
public class RemoveLower extends Command {
    @Override
    public void onCall(String args) throws IOException {
        LabWorkUserInputReader ir = new LabWorkUserInputReader();
        LabWork lw = ir.getUserInput();

        boolean flag = true;
        while (flag) {
            flag = false;
            for (LabWork labwork : Main.getSet()) {
                if (labwork.compareTo(lw) < 0) {
                    Main.getSet().remove(labwork);
                    flag = true;
                    break;
                }
            }
        }
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
