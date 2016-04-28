package demo.java.util;

import java.util.ServiceLoader;

public class ServiceLoaderExample {

    public static void main(String[] args) {
        ServiceLoader<Command> serviceLoaders = ServiceLoader.load(Command.class);
        for(Command command : serviceLoaders) {
            command.execute();
        }
    }

}
