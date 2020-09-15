package commands;

import main.Main;

public class Clear extends Command {
    @Override
    public void onCall(String args) {
        Main.getSet().clear();
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
