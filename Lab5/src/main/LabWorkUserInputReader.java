package main;

import java.util.InputMismatchException;

public class LabWorkUserInputReader {

    public LabWork getUserInput() {

        String name = "";
        while(true) {
            System.out.println("enter the name:");
            name = Main.sc.nextLine();
            if (name == null || name.isEmpty()) {
                System.out.println("the name can't be blank");
                continue;
            }else{
                break;
            }
        }

        long x;
        while (true) {
            System.out.println("enter the x coordinate:");
            try {
                x = Main.sc.nextLong();
            }catch (InputMismatchException e){
                Main.sc.nextLine();
                System.out.println("it looks like what you entered is not an integer");
                continue;
            }
            Main.sc.nextLine();
            break;
        }

        int y;
        while(true) {
            System.out.println("enter the y coordinate:");
            try {
                y = Main.sc.nextInt();
            } catch (InputMismatchException e) {
                Main.sc.nextLine();
                System.out.println("it looks like what you entered is not an integer");
                continue;
            }
            Main.sc.nextLine();
            break;
        }

        Coordinates coordinates = new Coordinates(x, y);

        double minimalPoint;
        while(true) {
            System.out.println("enter the minimal point:");
            try {
                minimalPoint = Main.sc.nextDouble();
            }catch(InputMismatchException e){
                Main.sc.nextLine();
                System.out.println("it looks like what you entered is not a number");
                continue;
            }
            Main.sc.nextLine();
            if(minimalPoint>0){
                break;
            }else{
                System.out.println("the minimal point has to be positive");
                continue;
            }
        }

        String description = "";
        while(true) {
            System.out.println("enter the description:");
            description = Main.sc.nextLine();
            if(description==null){
                System.out.println("somehow the description is null, try again");
                continue;
            }else{
                if(description.length()>843){
                    System.out.println("the description can not be longer than 843 symbols");
                    continue;
                }else{
                    break;
                }
            }
        }

        Difficulty difficulty;
        while(true) {
            System.out.println("enter the difficulty (VERY_EASY, HARD, VERY_HARD, IMPOSSIBLE, HOPELESS):");
            try {
                difficulty = Difficulty.valueOf(Main.sc.nextLine());
            }catch(IllegalArgumentException e){
                System.out.println("you can only choose one of the given options");
                continue;
            }
            break;
        }

        String authorName = "";
        while(true) {
            System.out.println("enter the name of the author:");
            authorName = Main.sc.nextLine();
            if (authorName == null || authorName.isEmpty()) {
                System.out.println("the name of the author can't be blank");
                continue;
            }else{
                break;
            }
        }

        int authorHeight;
        while(true) {
            System.out.println("enter the height of the author:");
            try {
                authorHeight = Main.sc.nextInt();
            }catch(InputMismatchException e){
                Main.sc.nextLine();
                System.out.println("it looks like what you entered is not an integer");
                continue;
            }
            Main.sc.nextLine();
            if(authorHeight>0){
                break;
            }else{
                System.out.println("the height of the author has to be positive");
                continue;
            }
        }

        Long authorWeight;
        while(true) {
            System.out.println("enter the weight of the author:");
            try {
                authorWeight = Main.sc.nextLong();
            }catch(InputMismatchException e){
                Main.sc.nextLine();
                System.out.println("it looks like what you entered is not an integer");
                continue;
            }
            Main.sc.nextLine();
            if(authorWeight>0){
                break;
            }else{
                System.out.println("the weight of the author has to be positive");
                continue;
            }
        }

        String authorPassportId = "";
        while(true) {
            System.out.println("enter the passport id of the author:");
            authorPassportId = Main.sc.nextLine();
            if(authorPassportId==null){
                System.out.println("somehow the passport id is null, try again");
                continue;
            }else{
                break;
            }
        }

        Color eyeColor;
        while (true) {
            System.out.println("enter the eye color of the author (GREEN, RED, BLACK, ORANGE, BROWN):");
            try {
                eyeColor = Color.valueOf(Main.sc.nextLine());
            }catch (IllegalArgumentException e){
                System.out.println("you can only choose one of the given options");
                continue;
            }
            break;
        }

        Person author = new Person(authorName, authorHeight, authorWeight, authorPassportId, eyeColor);

        return (new LabWork(name, coordinates, minimalPoint, description, difficulty, author));

    }

}
