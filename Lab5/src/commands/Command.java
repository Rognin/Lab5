/**the class that has all the command classes as descendants*/
package commands;

import java.io.IOException;

public class Command {

    /**
     * the main method that determines how a command functions
     * @param args the parameter for a command
     * */
    public void onCall(String args) throws IOException {
    }

    /**used to process the argument*/
    public void getArgs(String args) {
    }

    /**
     * used to get command-specific help, currently not implemented
     * @return the helping information
     * */
    public String getHelp() {
        return "";
    }
}
