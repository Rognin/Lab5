/**
 * The main class, launches the program
 *
 * @author Artem Gusev
 * @version 1.0
 */
package main;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

import commands.*;

public class Main {

    /**
     * the name of the save-load file
     */
    public static String fileName = "";
    public static File inputFile;

    /**
     * a queue for keeping track of command history
     */
    public static Queue<String> history = new ArrayDeque<>();

    /**
     * the main collection with Labworks
     */
    static HashSet<LabWork> set = new HashSet<LabWork>();

    /**
     * the date of last collection initialization
     */
    public static Date date = new Date();

    public static HashSet<LabWork> getSet() {
        return set;
    }

    public static Scanner sc = new Scanner(System.in);

    /**
     * a map that contains a copy of each command
     */
    public static HashMap<String, Command> commands = new HashMap<String, Command>();

    /**
     * a method for getting the extension of a file from it's name
     *
     * @param fileName
     * @return extension
     */
    public static String getFileExtensionFromName(String fileName) {
        // если в имени файла есть точка и она не является первым символом в названии файла
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".") + 1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }

    /**
     * a method for reading the next command
     */
    public static String readNextCommand() {
        return sc.nextLine();
    }

    /**
     * a method that executes a command
     *
     * @param s the name of the command
     */
    public static void executeNextCommand(String s) throws NullPointerException {
        try {
            int index = s.indexOf(' ');
//            System.out.println(index);

            String commandName;
            String keyWords;

            if (index > -1) {
                commandName = s.substring(0, index);
                keyWords = s.substring(index + 1);
            } else {
                commandName = s;
                keyWords = "";
            }
//            System.out.println(commandName);
//            System.out.println(keyWords);
            if (history.size() > 5) {
                history.poll();
                history.add(commandName);
            } else {
                history.add(commandName);
            }
            commands.get(commandName).onCall(keyWords);
        } catch (NullPointerException e) {
            System.out.println("There is no such command");
        } catch (IOException e) {
            System.out.println("we don't have a permission to interact with a file (or an unknown error occurred)");
        } catch (NoSuchElementException e) {
            System.out.println(":(");
        }
    }

    public static void main(String[] args) throws IOException {
        commands.put("help", new Help());
        commands.put("info", new Info());
        commands.put("show", new Show());
        commands.put("add", new Add());
        commands.put("update", new Update());
        commands.put("remove_by_id", new Remove_by_id());
        commands.put("clear", new Clear());
        commands.put("save", new Save());
        commands.put("execute_script", new ExecuteScript());
        commands.put("add_if_min", new AddIfMin());
        commands.put("remove_lower", new RemoveLower());
        commands.put("history", new History());
        commands.put("max_by_id", new MaxById());
        commands.put("filter_less_than_description", new FilterLessThanDescription());
        commands.put("filter_greater_than_description", new FilterGreaterThanDescription());

        fileName = System.getenv("SET_PATH");
        if (fileName == null) {
            System.out.println("an environment variable SET_PATH was expected");
            fileName = "theSet.csv";
            System.out.println("the file name has been set to the default (theSet.csv)");
        }

        boolean load = true;
        boolean isCsv = true;

        if (!getFileExtensionFromName(fileName).equals("csv")) {
            System.out.println("the file specified in the SET_PATH environment variable is not .csv (nothing was loaded)");
            load = false;
            isCsv = false;
        }

        if (!isCsv) {
            fileName += ".csv";
            System.out.println("we will try to create a save-load file named " + fileName);
            inputFile = new File(fileName);
            try {
                inputFile.createNewFile();
                System.out.println("success");
            } catch (IOException e) {
                System.out.println("looks like we can't create the file");
                load = false;
            }
            System.out.println("please change the SET_PATH environment variable to " + fileName);
        } else {
            inputFile = new File(fileName);
            if (!inputFile.exists()) {
                try {
                    inputFile.createNewFile();
                    System.out.println("there was no file by the name specified in the SET_PATH environment variable so we created a new one");
                } catch (IOException e) {
                    System.out.println("the file specified in the SET_PATH environment variable doesn't exist and we can't create a new one");
                    load = false;
                }
            }
        }

        /**a BufferedInputStream for reading the collection info from it's file*/

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));

        BufferedReader br = new BufferedReader(new InputStreamReader(bis));

        //loadCollection
        if (load) {
            while (true) {

                String input = null;
                try {
                    input = br.readLine();
                } catch (IOException e) {
                    System.out.println("error 001");
                }

                if (input == null || input.isEmpty()) break;
                String[] currentInput = input.split(",");
                String[] date = currentInput[4].split("-");
                LocalDate theDate = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
                set.add(new LabWork(Long.parseLong(currentInput[0]), currentInput[1], new Coordinates(Long.parseLong(currentInput[2]), Integer.parseInt(currentInput[3])), theDate, Double.parseDouble(currentInput[5]), currentInput[6], Difficulty.valueOf(currentInput[7]), new Person(currentInput[8], Integer.parseInt(currentInput[9]), Integer.parseInt(currentInput[10]), currentInput[11], Color.valueOf(currentInput[12]))));
            }
        }

        while (sc.hasNext()) {
            String input = readNextCommand();
            if (input.equals("exit"))
                break;
            if (input.equals(""))
                continue;
            executeNextCommand(input);
        }
    }

}
