package javat.lang;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        tt.doSleep();
        System.out.println("I am tired...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Oh yeah~");
    }

    public void doSleep() {
        Sleepy sleepy = new Sleepy();
        new Thread(sleepy).start();
    }

    class Sleepy implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("I want to sleep!");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("Have a good time ^_^");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
