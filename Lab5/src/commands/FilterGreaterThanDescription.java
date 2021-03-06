package commands;

import main.LabWork;
import main.Main;

import java.io.IOException;

/**print all the element with a description value greater than the given one*/
public class FilterGreaterThanDescription extends CommandWithArgs{

    /**the given description*/
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
        super.getArgs(args);
        description = super.args;
    }

    @Override
    public String getHelp() {
        return super.getHelp();
    }
}
