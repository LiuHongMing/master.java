package javat.concurrent.locks;

import java.util.Date;
import java.util.concurrent.locks.LockSupport;

public class LockSupportView extends Thread {

    static LockSupportView threadTest;

    private Thread currentThread;

    LockSupportView(Thread currentThread, String name) {
        this.currentThread = currentThread;
        System.out.println(currentThread.getName() + " will be blocked");
        setName(name);
    }

    public static void main(String[] args) {
        threadTest = new LockSupportView(Thread.currentThread(), "LockSupport new thread");
        threadTest.start();
        park();
        System.out.println("main thread >>>");
    }

    static void park() {
        System.out.println("[" + new Date() + "], " + Thread.currentThread().getName() + ", before >>>");
        LockSupport.park(Thread.currentThread());
        System.out.println("[" + new Date() + "], " + Thread.currentThread().getName() + ", after  >>>");
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " start >>>");
            Thread.sleep(10000);
            LockSupport.unpark(currentThread);
            System.out.println(Thread.currentThread().getName() + " end >>>");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
