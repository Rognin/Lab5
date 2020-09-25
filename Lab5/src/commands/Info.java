package commands;

import main.*;

import java.util.HashSet;

/**print information about the main collection*/
public class Info extends Command{
    @Override
    public void onCall(String args) {
        HashSet<LabWork> hs = Main.getSet();

        System.out.println("class: " + hs.getClass() + "\n" +
                "initialization date: "+Main.date.toString()+"\n"+
                "number of elements:"+Main.getSet().size());
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
