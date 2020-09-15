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
                Main.getSet().remove(lw);
            }
        }


        if (flag) {
            System.out.println("enter the name:");
            String name = Main.sc.nextLine();

            System.out.println("enter the x coordinate:");
            long x = (int) Main.sc.nextInt();

            System.out.println("enter the y coordinate:");
            int y = (int) Main.sc.nextInt();
            Coordinates coordinates = new Coordinates(x, y);

            java.time.LocalDate creationDate = LocalDate.now();

            System.out.println("enter the minimal point:");
            double minimalPoint = Main.sc.nextDouble();
            Main.sc.nextLine();

            System.out.println("enter the description:");
            String description = Main.sc.nextLine();

            System.out.println("enter the difficulty (VERY_EASY, HARD, VERY_HARD, IMPOSSIBLE, HOPELESS):");
            Difficulty difficulty = Difficulty.valueOf(Main.sc.nextLine());

            System.out.println("enter the name of the author:");
            String authorName = Main.sc.nextLine();

            System.out.println("enter the height of the author:");
            int authorHeight = Main.sc.nextInt();

            System.out.println("enter the weight of the author:");
            long authorWeight = Main.sc.nextLong();
            Main.sc.nextLine();

            System.out.println("enter the passport id of the author:");
            String authorPassportId = Main.sc.nextLine();

            System.out.println("enter the eye color of the author (GREEN, RED, BLACK, ORANGE, BROWN):");
            main.Color eyeColor = Color.valueOf(Main.sc.nextLine());

            Person author = new Person(authorName, authorHeight, authorWeight, authorPassportId, eyeColor);

            boolean extraflag = false;

            if (flag) {
                Main.getSet().add(new LabWork(id, name, coordinates, minimalPoint, description, difficulty, author));

            }
        } else {
            System.out.println("There is no element with this id");
        }

    }

    @Override
    public void getArgs(String args) {
        if (args.equals("")) {
            System.out.println("please enter the id of the element you need to change");
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
