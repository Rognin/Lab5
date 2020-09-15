package commands;

import main.*;

import java.io.IOException;

public class RemoveLower extends Command{
    @Override
    public void onCall(String args) throws IOException {
        System.out.println("enter the name:");
        String name = Main.sc.nextLine();

        System.out.println("enter the x coordinate:");
        long x = (int) Main.sc.nextInt();

        System.out.println("enter the y coordinate:");
        int y = (int) Main.sc.nextInt();
        Coordinates coordinates = new Coordinates(x, y);

        System.out.println("enter the minimal point:");
        double minimalPoint = Main.sc.nextDouble();;
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
        Color eyeColor = Color.valueOf(Main.sc.nextLine());

        Person author = new Person(authorName, authorHeight, authorWeight, authorPassportId, eyeColor);

        Main.getSet().add(new LabWork(name, coordinates, minimalPoint, description, difficulty, author));

        LabWork lw = new LabWork(name, coordinates, minimalPoint, description, difficulty, author);

        for (LabWork labwork:Main.getSet()){
            if(labwork.compareTo(lw)<0) Main.getSet().remove(labwork);
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
