package commands;

import main.LabWork;
import main.Main;

import java.io.IOException;

public class MaxById extends Command {
    @Override
    public void onCall(String args) throws IOException {
        long maxId = 0;
        for (LabWork lw : Main.getSet()) {
            if (lw.getId() > maxId) maxId = lw.getId();
        }
        for (LabWork lw : Main.getSet()) {
            if (lw.getId() == maxId) {
                System.out.println(lw);
                break;
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
