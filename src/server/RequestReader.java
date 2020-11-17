package server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RequestReader {
    public void readRequest() throws IOException {
        ServerTCP.in = new ObjectInputStream(ServerTCP.socket.getInputStream());

    }
}
