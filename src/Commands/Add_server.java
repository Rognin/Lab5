package Commands;

import main.LabWork;
import main.LabWorkUserInputReader;
import main.Main;
import server.ServerTCP;

/**add an element to the collection*/
public class Add_server extends Command_server{
    @Override
    public void onCall(String args) {

        LabWork lw = (LabWork) ServerTCP.additionalInput;
        lw.setId((long) ServerTCP.getNumerOfElements()+1);
        ServerTCP.getSet().add(lw);
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
