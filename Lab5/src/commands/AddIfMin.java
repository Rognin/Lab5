package commands;

import main.*;

import java.io.IOException;

/**add an element to the collection if it's the smallest one*/
public class AddIfMin extends Command {
    @Override
    public void onCall(String args) throws IOException {

        LabWorkUserInputReader ir = new LabWorkUserInputReader();
        LabWork lw = ir.getUserInput();

        boolean flag = true;
        for (LabWork labwork : Main.getSet()) {
            if (labwork.compareTo(lw) < 0) flag = false;
        }

        if (flag) Main.getSet().add(lw);

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
