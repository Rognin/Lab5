package Commands;

import main.LabWork;
import main.LabWorkUserInputReader;
import main.Main;
import server.ServerTCP;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * remove all elements with a value less than that of the given one
 */
public class RemoveLower_server extends Command_server {
    @Override
    public void onCall(String args) throws IOException {
        LabWork lw = (LabWork) ServerTCP.additionalInput;

        Set<LabWork> set = ServerTCP.getSet().stream().filter((l) -> l.compareTo(lw) < 0).collect(Collectors.toSet());
        set.forEach(l -> ServerTCP.getSet().remove(l));
        ServerTCP.answer = "success";
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
