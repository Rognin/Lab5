/**command child created to give all commands with a parameter a common processing method*/
package Commands;

import main.Main;

public class CommandWithArgs_server extends Command{
    private static final long serialVersionUID = 1;

    /**the value is the argument*/
    String args = "";

    /**
     * used to process the argument and account for the case when the argument is missing
     * @param args the argument
     * */
    @Override
    public void getArgs(String args) {
        super.getArgs(args);
        this.args=args;
        if(this.args.isEmpty()){
            System.out.println("please enter the argument(s)");
            String tmpArgs = Main.scanner.nextLine();
            getArgs(tmpArgs);
        }
    }
}
