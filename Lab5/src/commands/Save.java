package commands;

import main.LabWork;
import main.Main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**save the collection to a file*/
public class Save extends Command {

    @Override
    public void onCall(String args) throws IOException {

        File file = Main.inputFile;

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("there is no file to save to and we can't create one");
                return;
            }
        }

        PrintWriter pw = new PrintWriter(file);
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
