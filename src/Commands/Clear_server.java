package Commands;

import main.Main;
import server.ServerTCP;

/**clear the collection*/
public class Clear_server extends Command_server {
    @Override
    public void onCall(String args) {
        ServerTCP.getSet().clear();
        ServerTCP.answer="success";
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
