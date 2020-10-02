package commands;

import main.LabWork;
import main.Main;

/**remove an element with the given id from the main collection*/
public class Remove_by_id extends Command {

    /**the given id*/
    long id;

    @Override
    public void onCall(String args) {

        getArgs(args);

        boolean flag = true;
        while (flag) {
            flag = false;
            for (LabWork lw : Main.getSet()) {
                if (lw.getId() == id) {
                    Main.getSet().remove(lw);
                    flag = true;
                    break;
                }
            }
        }
        System.out.println("success");
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
