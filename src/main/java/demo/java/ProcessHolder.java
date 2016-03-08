package demo.java;

import java.io.IOException;

public class ProcessHolder {

    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("java", "Visitor");
        pb.start();
    }

}
