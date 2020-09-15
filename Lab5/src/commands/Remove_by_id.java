package commands;

import main.LabWork;
import main.Main;

public class Remove_by_id extends Command {

    long id;

    @Override
    public void onCall(String args) {

        getArgs(args);

        for (LabWork lw : Main.getSet()) {
            if (lw.getId() == id) {
                Main.getSet().remove(lw);
            }
        }
    }

    @Override
    public void getArgs(String args) {
        if (args.equals("")) {
            System.out.println("please enter the id of the element you need to remove");
            id = Main.sc.nextInt();
            Main.sc.nextLine();
        } else {
            id = Integer.parseInt(args);
        }
    }

    @Override
    public String getHelp() {
        return super.getHelp();
    }
}
