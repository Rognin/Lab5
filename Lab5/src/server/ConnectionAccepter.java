package server;

import java.io.IOException;
import java.net.ServerSocket;

public class ConnectionAccepter {
    public void acceptClient() throws IOException {
        ServerTCP.socket = ServerTCP.server.accept();
        System.out.println("Client accepted");
    }
}
