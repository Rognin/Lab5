package server;

import java.io.DataOutputStream;
import java.io.IOException;

public class AnswerSender {
    public void sendAnswer(String output) throws IOException {
        ServerTCP.out.writeUTF(output);
        ServerTCP.out.flush();
    }
}
