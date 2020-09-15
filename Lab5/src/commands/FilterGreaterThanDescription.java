package commands;

import main.LabWork;
import main.Main;

import java.io.IOException;

public class FilterGreaterThanDescription extends Command{
    String description;

    @Override
    public void onCall(String args) throws IOException {
        getArgs(args);
        for(LabWork lw: Main.getSet()){
            if(lw.getDescription().compareTo(description)>0) System.out.println(lw);
        }
    }

    @Override
    public void getArgs(String args) {
        description = args;
    }

    @Override
    public String getHelp() {
        return super.getHelp();
    }
}
