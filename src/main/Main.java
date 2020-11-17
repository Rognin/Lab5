/**
 * The main class, launches the program
 *
 * @author Artem Gusev
 * @version 1.0
 */
package main;

import java.net.*;
import java.io.*;
import java.util.*;

import Commands.*;
import server.ServerTCP;

public class Main {

    public static Object additionalOutputToServer = null;

    private static Socket socket = null;
    private static BufferedReader input = null;
    private static ObjectInputStream in = null;
    private static ObjectOutputStream out = null;
//    private static BufferedWriter bw = null;

    /**
     * a queue for keeping track of command history
     */
    public static Queue<String> history = new ArrayDeque<>();

    /**
     * the date of last collection initialization
     */
    public static Date date = new Date();

    public static Scanner sc = new Scanner(System.in);

    /**
     * a map that contains a copy of each command
     */
    public static HashMap<String, Command> commands = new HashMap<String, Command>();
    public static HashMap<String, Command> serverCommands = new HashMap<String, Command>();

    /**
     * a method that executes a command
     *
     * @param s the name of the command
     */
    public static Command executeNextCommand(String s) throws NullPointerException, NoSuchElementException {

        int index = s.indexOf(' ');

        String commandName;
        String keyWords;

        if (index > -1) {
            commandName = s.substring(0, index);
            keyWords = s.substring(index + 1);
        } else {
            commandName = s;
            keyWords = "";
        }
        try {

            if (history.size() > 5) {
                history.poll();
            }
            history.add(commandName);
            commands.get(commandName).onCall(keyWords);

        } catch (NullPointerException e) {
            System.out.println("There is no such command");
            return null;
        } catch (IOException e) {
            System.out.println("we don't have a permission to interact with a file (or an unknown error occurred)");
            return null;
        }
        return (serverCommands.get(commandName));
    }

    public static boolean tryToConnect() {
        try {
            socket = new Socket("127.0.0.1", 5000);
            System.out.println("Connected");
            // sends output to the socket
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
//            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (UnknownHostException u) {
            System.out.println("unknown host exception");
            return false;
        } catch (ConnectException e) {
            System.out.println("Server is unavailable. Try again by entering 'connect'");
            return false;
        } catch (IOException i) {
            System.out.println("io exception");
            i.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        commands.put("help", new Help());
        commands.put("info", new Info());
        commands.put("show", new Show());
        commands.put("add", new Add());
        commands.put("update", new Update());
        commands.put("remove_by_id", new Remove_by_id());
        commands.put("clear", new Clear());
        commands.put("execute_script", new ExecuteScript());
        commands.put("add_if_min", new AddIfMin());
        commands.put("remove_lower", new RemoveLower());
        commands.put("history", new History());
        commands.put("max_by_id", new MaxById());
        commands.put("filter_less_than_description", new FilterLessThanDescription());
        commands.put("filter_greater_than_description", new FilterGreaterThanDescription());

        serverCommands.put("help", new Help_server());
        serverCommands.put("info", new Info_server());
        serverCommands.put("show", new Show_server());
        serverCommands.put("add", new Add_server());
        serverCommands.put("update", new Update_server());
        serverCommands.put("remove_by_id", new Remove_by_id_server());
        serverCommands.put("clear", new Clear_server());
        serverCommands.put("save", new Save_server());
        serverCommands.put("execute_script", new ExecuteScript_server());
        serverCommands.put("add_if_min", new AddIfMin_server());
        serverCommands.put("remove_lower", new RemoveLower_server());
        serverCommands.put("history", new History_server());
        serverCommands.put("max_by_id", new MaxById_server());
        serverCommands.put("filter_less_than_description", new FilterLessThanDescription_server());
        serverCommands.put("filter_greater_than_description", new FilterGreaterThanDescription_server());

        // takes input from terminal
        input = new BufferedReader(new InputStreamReader(System.in));

        boolean isConnected = tryToConnect();

        String line = "";

        while (true) {
            line = "";
            if (input.ready()) {
                try {
                    line = input.readLine();
                } catch (IOException e) {
                    System.out.println("io exception while trying to read something from input");
                    e.printStackTrace();
                    break;
                }
            }
            try {
                try {
                    if (line.equals("exit"))
                        break;
                    if (line.equals("connect")) {
                        isConnected = tryToConnect();
                        continue;
                    }
                    if (line.equals(""))
                        continue;
                    if (!isConnected) continue;
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

                Command currentCommand = executeNextCommand(line);
//                System.out.println("command executed");

                if (currentCommand == null) {
                    additionalOutputToServer=null;
                    continue;
                }

//                bw.write(1);
//                bw.flush();
                out.writeObject(currentCommand);
                out.writeObject(additionalOutputToServer);
                additionalOutputToServer = null;
                out.flush();
                System.out.println("sent command to server");
                String answer = in.readUTF();
                System.out.println("answer received");
                System.out.println(answer);
            } catch (NullPointerException e) {
                e.printStackTrace();
                break;
            } catch (SocketException e) {
                System.out.println("server is down. You can try to connect again by entering 'connect'");
                isConnected = false;
                continue;
            } catch (EOFException e) {
                System.out.println(e);
                e.printStackTrace();
                break;
            } catch (NoSuchElementException e){
                System.out.println(":(");
                break;
            }
        }
        // close the connection
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println("failed to close something");
        }

    }

}
