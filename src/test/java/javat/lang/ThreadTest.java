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
        new Thread(sleepy, "Sleepy").start();

        Counter counter = new Counter();
        new Thread(counter, "Counter").start();
    }

    class Sleepy implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("I want to sleep!");
                TimeUnit.SECONDS.sleep(100000);
                System.out.println("Have a good time ^_^");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Counter implements Runnable {

        private volatile int result = 0;

        @Override
        public void run() {
            int val = 0;
            for (int i = 0; i < 100; i++) {
                val += i;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            result = val;
        }
    }

}
