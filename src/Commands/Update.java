package Commands;

import main.*;
import server.ServerTCP;

/**
 * update the value of the element with the given id
 */
public class Update extends Command {

    /**
     * the given id
     */
    long id;

    @Override
    public void onCall(String args) {
        getArgs(args);

        LabWorkUserInputReader ir = new LabWorkUserInputReader();
        LabWork lw = ir.getUserInput();

        UpdateObjectsPack uop = new UpdateObjectsPack();

        uop.setId(id);
        uop.setLw(lw);

        Main.additionalOutputToServer = uop;

    }

    @Override
    public void getArgs(String args) {
        if (args.equals("")) {
            System.out.println("please enter the id of the element you need to update");
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
