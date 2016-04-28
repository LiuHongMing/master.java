package demo.java.util;

public class ShutdownCommand implements Command {

    @Override
    public void execute() {
        System.out.println("shutdown...");
    }

}
