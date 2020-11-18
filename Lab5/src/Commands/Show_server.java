package Commands;

import main.LabWork;
import main.Main;
import server.ServerTCP;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

/**
 * list all the elements of the main collection
 */
public class Show_server extends Command_server {
    @Override
    public void onCall(String args) throws IOException {
//        HashSet<LabWork> set = ServerTCP.getSet();
//        Iterator<LabWork> i = set.iterator();
//        while (i.hasNext()) ServerTCP.answer+=("\n"+i.next().toString());
        ServerTCP.getSet().forEach(l -> ServerTCP.answer += "\n" + l.toString());
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
