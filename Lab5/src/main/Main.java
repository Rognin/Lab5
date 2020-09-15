package main;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

import commands.*;

public class Main {

    public static Queue<String> history = new ArrayDeque<>();

    static HashSet<LabWork> set = new HashSet<LabWork>();
    public static Date date = new Date();

//    static HashMap<Integer, LabWork> map = new HashMap<Integer, LabWork>();

    public static HashSet<LabWork> getSet() {
        return set;
    }

//    public static HashMap<Integer, LabWork> getMap() {
//        return map;
//    }

    public static Scanner sc = new Scanner(System.in);

    // a map containing commands
    public static HashMap<String, Command> commands = new HashMap<String, Command>();

    public static String readNextCommand() {
        return sc.nextLine();
    }

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
            if(history.size()>5){
                history.poll();
                history.add(commandName);
            }else{
                history.add(commandName);
            }
            commands.get(commandName).onCall(keyWords);
        } catch (NullPointerException e) {
            System.out.println("There is no such command");
        } catch (IOException e) {
            System.out.println("An IO exception of some sort occured");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
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

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("theSet.csv")));
        BufferedReader br = new BufferedReader(new InputStreamReader(bis));
        while(true){

            String input = null;
            try {
                input = br.readLine();
            } catch (IOException e) {
                System.out.println("error 001");
            }

            if(input == null || input.isEmpty())break;
            String[] currentInput = input.split(",");
            String[] date = currentInput[4].split("-");
            LocalDate theDate = LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
            set.add(new LabWork(Long.parseLong(currentInput[0]), currentInput[1], new Coordinates(Long.parseLong(currentInput[2]), Integer.parseInt(currentInput[3])), theDate, Double.parseDouble(currentInput[5]), currentInput[6], Difficulty.valueOf(currentInput[7]), new Person(currentInput[8], Integer.parseInt(currentInput[9]), Integer.parseInt(currentInput[10]),currentInput[11], Color.valueOf(currentInput[12]))));
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
