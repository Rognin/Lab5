package server;

// A Java program for a Serverside

import Commands.*;
import main.*;

import java.net.*;
import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ServerTCP {
    static public boolean commandReady;
    //initialize socket and input stream
    static Socket socket = null;
    static ServerSocket server = null;
    public static ObjectInputStream in = null;
    public static ObjectOutputStream out = null;
//    public static BufferedReader checkForCommand = null;

    public static Command currentCommand;
    public static Object additionalInput;

    /**
     * the main collection with Labworks
     */
    static private HashSet<LabWork> set = new HashSet<LabWork>();

    public static HashSet<LabWork> getSet() {
        return set;
    }

    public static int getNumerOfElements() {
        return set.size();
    }

    public static String answer = "";

    public static File inputFile;

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

    public static boolean checkAbilityToLoad(String fileName) {

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
        return load;
    }

    public static void load(File inputFile) throws FileNotFoundException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));

        BufferedReader br = new BufferedReader(new InputStreamReader(bis));

        while (true) {
            String input = null;
            try {
                input = br.readLine();
            } catch (IOException e) {
                System.out.println("IO exception while trying to load the collection, probably can't read the file");
            }

            if (input == null || input.isEmpty()) break;
            String[] currentInput = input.split(",");
            String[] date = currentInput[4].split("-");
            LocalDate theDate = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            set.add(new LabWork(Long.parseLong(currentInput[0]), currentInput[1], new Coordinates(Long.parseLong(currentInput[2]), Integer.parseInt(currentInput[3])), theDate, Double.parseDouble(currentInput[5]), currentInput[6], Difficulty.valueOf(currentInput[7]), new Person(currentInput[8], Integer.parseInt(currentInput[9]), Integer.parseInt(currentInput[10]), currentInput[11], Color.valueOf(currentInput[12]))));
        }
    }


    public static void main(String args[]) {

        int port = 5000;
        CommandProcesser cp = new CommandProcesser();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileName = System.getenv("SET_PATH");
        boolean load = checkAbilityToLoad(fileName);
        try {
            if (load) load(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("collection file not found");
        }


        try {

            server = new ServerSocket(port);
            System.out.println("Server started");
            while (true) {
                System.out.println("Waiting for a client ...");
                ServerTCP.socket = ServerTCP.server.accept();
                System.out.println("Client accepted");
                out = new ObjectOutputStream(socket.getOutputStream());
                in = new ObjectInputStream(socket.getInputStream());
//            checkForCommand = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {
                    if (br.ready()) {
                        String input = br.readLine();
                        if (input.equals("exit")) return;
                        if (input.equals("")) break;
                        if (input.equals("save")) {
                            Command_server save = new Save_server();
                            save.onCall("");
                        } else {
                            System.out.println("There is no such command");
                        }

                    }
                    try {
//                    int tmp = checkForCommand.read();
                        System.out.println("waiting for the command");
                        currentCommand = (Command) in.readObject();
                        additionalInput = in.readObject();
                        if(currentCommand==null){
                            System.out.println("an empty command was received");
                            out.writeUTF("something went wrong, try again");
                            out.flush();
                            System.out.println("answer sent");
                            continue;
                        }
                        System.out.println("command " + currentCommand.getClass() + " received trying to execute");
                        try {
                            cp.executeCommand();
                        } catch (NullPointerException e) {
                            System.out.println("nullpointer");
                            e.printStackTrace();
                            continue;
                        }
//                    answer = "yey";
                        System.out.println("executed now sending the answer");
                        ServerTCP.out.writeUTF(answer);
                        ServerTCP.out.flush();
                        System.out.println("executed, answer sent");
                        answer = "";
                    } catch (EOFException e) {
                        System.out.println("client disconnected");
                        break;
                    } catch (SocketException e) {
                        System.out.println("socketEx");
                    } catch (IOException i) {
                        System.out.println(i);
                        i.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Command save = new Save_server();
        try {
            save.onCall("");
        } catch (IOException e) {
            System.out.println("couldn't save");
        }
    }
}