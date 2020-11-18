/**a class used for getting user input for creating a copy of LabWork*/
package main;

import java.util.InputMismatchException;

public class LabWorkUserInputReader {

    /**
     * the method used to get user input for creating a copy of LabWork
     * @return a LabWork with the values entered by a user
     * */
    public LabWork getUserInput() {

        String name = "";
        while(true) {
            System.out.println("enter the name:");
            name = Main.scanner.nextLine();
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
                x = Main.scanner.nextLong();
            }catch (InputMismatchException e){
                Main.scanner.nextLine();
                System.out.println("it looks like what you entered is not an integer");
                continue;
            }
            Main.scanner.nextLine();
            break;
        }

        int y;
        while(true) {
            System.out.println("enter the y coordinate:");
            try {
                y = Main.scanner.nextInt();
            } catch (InputMismatchException e) {
                Main.scanner.nextLine();
                System.out.println("it looks like what you entered is not an integer");
                continue;
            }
            Main.scanner.nextLine();
            break;
        }

        Coordinates coordinates = new Coordinates(x, y);

        double minimalPoint;
        while(true) {
            System.out.println("enter the minimal point:");
            try {
                minimalPoint = Main.scanner.nextDouble();
            }catch(InputMismatchException e){
                Main.scanner.nextLine();
                System.out.println("it looks like what you entered is not a number");
                continue;
            }
            Main.scanner.nextLine();
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
            description = Main.scanner.nextLine();
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
                difficulty = Difficulty.valueOf(Main.scanner.nextLine());
            }catch(IllegalArgumentException e){
                System.out.println("you can only choose one of the given options");
                continue;
            }
            break;
        }

        String authorName = "";
        while(true) {
            System.out.println("enter the name of the author:");
            authorName = Main.scanner.nextLine();
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
                authorHeight = Main.scanner.nextInt();
            }catch(InputMismatchException e){
                Main.scanner.nextLine();
                System.out.println("it looks like what you entered is not an integer");
                continue;
            }
            Main.scanner.nextLine();
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
                authorWeight = Main.scanner.nextLong();
            }catch(InputMismatchException e){
                Main.scanner.nextLine();
                System.out.println("it looks like what you entered is not an integer");
                continue;
            }
            Main.scanner.nextLine();
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
            authorPassportId = Main.scanner.nextLine();
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
                eyeColor = Color.valueOf(Main.scanner.nextLine());
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
