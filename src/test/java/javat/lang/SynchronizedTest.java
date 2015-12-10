package javat.lang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ²»¿¿Æ×µÄÀý×Ó
 */
public class SynchronizedTest {

    private static int num = 100;
    private static SynchronizedTest test = new SynchronizedTest();

    public static synchronized void staticSyn() {
        int i = 0;
        while (i < 10) {
            num--;
            i++;
            try {
                System.out.println(Thread.currentThread().getName() + ":static" + ":" + num);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void nonStaticSyn() {
        int i = 0;
        while (i < 10) {
            num--;
            i++;
            try {
                System.out.println(Thread.currentThread().getName() + ":nonStatic" + ":" + num);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new Tnss());
        es.execute(new Tnss());
//        es.execute(new Tss());
//        es.execute(new Tss());
        es.shutdown();
    }

}

class Tss implements Runnable {

    @Override
    public void run() {
        SynchronizedTest syn = new SynchronizedTest();
        syn.staticSyn();
    }
}

class Tnss implements Runnable {

    @Override
    public void run() {
        SynchronizedTest syn = new SynchronizedTest();
        syn.nonStaticSyn();
    }
}
