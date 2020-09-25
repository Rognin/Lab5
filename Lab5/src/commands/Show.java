package commands;

import main.*;

import java.util.HashSet;
import java.util.Iterator;

/**list all the elements of the main collection*/
public class Show extends Command {
    @Override
    public void onCall(String args) {
        HashSet<LabWork> set = Main.getSet();
        Iterator<LabWork> i = set.iterator();
        while (i.hasNext()) System.out.println(i.next().toString());
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
