package commands;

import main.LabWork;
import main.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**save the collection to a file*/
public class Save extends Command {
    @Override
    public void onCall(String args) throws IOException {
        PrintWriter pw = new PrintWriter(new File("theSet.csv"));
        for (LabWork lw:Main.getSet()) {
            pw.print(lw.getId()+","+lw.getName()+","+lw.getCoordinates().getX()+","+lw.getCoordinates().getY()+","+lw.getCreationDate()+","+lw.getMinimalPoint()+","+lw.getDescription()+","+lw.getDifficulty()+","+lw.getAuthor().getName()+","+lw.getAuthor().getHeight()+","+lw.getAuthor().getWeight()+","+lw.getAuthor().getPassportID()+","+lw.getAuthor().getEyeColor());
            pw.println();
        }
        System.out.println("success");
        pw.close();
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
