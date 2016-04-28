package demo.java.util;

public class StartCommand implements Command {

    @Override
    public void execute() {
        System.out.println("start...");
    }

}
