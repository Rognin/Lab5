package server;

import Commands.Command;

import java.io.IOException;

public class CommandProcesser {
    public void executeCommand() throws IOException {
        Command command = ServerTCP.currentCommand;
        command.onCall("");
    }
}
