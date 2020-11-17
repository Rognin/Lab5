package Commands;

import main.Main;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

/**print the last 6 commands entered*/
public class History extends Command {
    @Override
    public void onCall(String args) throws IOException {
        Queue<String> history = new ArrayDeque<>(Main.history);
        for (int i = 0; i < Main.history.size(); i++) {
            System.out.println(history.poll());
        }
    }

    @Override
    public void getArgs(String args) {
        super.getArgs(args);
    }

    @Override
    public String getHelp() {
        return super.getHelp();
    }
}
