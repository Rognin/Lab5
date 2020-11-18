package Commands;

import main.LabWork;
import main.LabWorkUserInputReader;
import main.Main;
import server.ServerTCP;

import java.io.IOException;
import java.time.LocalDate;

/**
 * update the value of the element with the given id
 */
public class Update_server extends Command_server {

    /**
     * the given id
     */
    long id;
    UpdateObjectsPack uop;

    @Override
    public void onCall(String args) throws IOException {

        uop = (UpdateObjectsPack) ServerTCP.additionalInput;
        LabWork lw = uop.getLw();
        id = uop.getId();
        lw.setId(id);
        lw.setCreationDate(LocalDate.now());

        boolean flag = ServerTCP.getSet().stream().anyMatch(l -> l.getId() == id);

        if (flag) {
            LabWork labWork = ServerTCP.getSet().stream().filter(l -> l.getId() == id).findAny().get();
            ServerTCP.getSet().remove(labWork);
            ServerTCP.getSet().add(lw);
            ServerTCP.answer = "success";
        } else {
            ServerTCP.answer = ("There is no element with this id");
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
