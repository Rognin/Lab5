package Commands;

import main.LabWork;
import main.Main;
import server.ServerTCP;

import java.io.IOException;
import java.util.stream.Collectors;

/**print all the element with a description value less than the given one*/
public class FilterLessThanDescription_server extends CommandWithArgs_server{

    /**the given description*/
    String description;

    @Override
    public void onCall(String args) throws IOException {
        description = (String) ServerTCP.additionalInput;
        ServerTCP.getSet().stream().filter((l) -> l.getDescription().compareTo(description) < 0).collect(Collectors.toList()).forEach((p) -> ServerTCP.answer += "\n" + p.toString());
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
