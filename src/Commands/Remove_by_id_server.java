package Commands;

import main.LabWork;
import main.Main;
import server.ServerTCP;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * remove an element with the given id from the main collection
 */
public class Remove_by_id_server extends Command_server {

    /**
     * the given id
     */
    long id;

    @Override
    public void onCall(String args) throws IOException {

        id = (long) ServerTCP.additionalInput;

        Set<LabWork> set = ServerTCP.getSet().stream().filter((l) -> l.getId() == id).collect(Collectors.toSet());
        set.forEach(l -> ServerTCP.getSet().remove(l));
        ServerTCP.answer = ("success");
    }

    @Override
    public void getArgs(String args) {
        if (args.equals("")) {
            System.out.println("please enter the id of the element you need to remove");
            try {
                id = Integer.parseInt(Main.sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("it looks like what you entered is not an integer. please enter again");
                getArgs(Main.sc.nextLine());
            }
        } else {
            try {
                id = Integer.parseInt(args);
            } catch (NumberFormatException e) {
                System.out.println("it looks like what you entered is not an integer. please enter again");
                getArgs(Main.sc.nextLine());
            }
        }
    }

    @Override
    public String getHelp() {
        return super.getHelp();
    }
}
