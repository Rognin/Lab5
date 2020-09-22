package commands;

import main.*;
import main.Color;

import java.awt.*;
import java.time.LocalDate;
import java.util.HashSet;

public class Update extends Command {

    long id;

    @Override
    public void onCall(String args) {
        getArgs(args);

        boolean flag = false;

        for (LabWork lw : Main.getSet()) {
            if (lw.getId() == id) {
                flag = true;
            }
        }


        if (flag) {

            LabWorkUserInputReader ir = new LabWorkUserInputReader();
            LabWork lw = ir.getUserInput();

            for (LabWork labwork : Main.getSet()) {
                if (labwork.getId() == id) Main.getSet().remove(labwork);
                break;
            }
            Main.getSet().add(lw);
        } else {
            System.out.println("There is no element with this id");
        }

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
