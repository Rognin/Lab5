package Commands;

import main.LabWork;
import main.LabWorkUserInputReader;
import main.Main;
import server.ServerTCP;

import java.io.IOException;
import java.time.LocalDate;

/**
 * add an element to the collection if it's the smallest one
 */
public class AddIfMin_server extends Command_server {
    @Override
    public void onCall(String args) throws IOException {

        if (ServerTCP.additionalInput != null) {

            LabWork lw = (LabWork) ServerTCP.additionalInput;
            lw.setId((long) (ServerTCP.getSet().size() + 1));
            lw.setCreationDate(LocalDate.now());
            boolean flag = true;
            for (LabWork labwork : ServerTCP.getSet()) {
                if (labwork.compareTo(lw) < 0) flag = false;
            }

            if (flag) {
                ServerTCP.getSet().add((LabWork) ServerTCP.additionalInput);
                ServerTCP.answer = "success";
            } else {
                ServerTCP.answer = "the element wasn't minimal";
            }
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
