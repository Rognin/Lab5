package Commands;

import main.Main;
import server.ServerTCP;

import java.io.IOException;

/**print information about the main collection*/
public class Info_server extends Command_server{
    @Override
    public void onCall(String args) throws IOException {

        ServerTCP.answer=("class: " + ServerTCP.getSet().getClass() + "\n" +
                "initialization date: "+Main.date.toString()+"\n"+
                "number of elements:"+ServerTCP.getSet().size());
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
