package server;

import Commands.Command;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RequestReader {
    public void readRequest() throws IOException, ClassNotFoundException {
        ServerTCP.currentCommand = (Command) ServerTCP.in.readObject();
        ServerTCP.additionalInput = ServerTCP.in.readObject();
    }
}
