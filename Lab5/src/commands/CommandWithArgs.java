package commands;

import main.Main;

public class CommandWithArgs extends Command{
    String args = "";
    @Override
    public void getArgs(String args) {
        super.getArgs(args);
        this.args=args;
        if(this.args.isEmpty()){
            System.out.println("please enter the argument(s)");
            String tmpArgs = Main.sc.nextLine();
            getArgs(tmpArgs);
        }
    }
}
