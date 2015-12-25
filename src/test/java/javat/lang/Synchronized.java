package javat.lang;

import java.util.concurrent.TimeUnit;

/**
 * 测试多线程下对同步方法(成员方法、静态方法)的访问控制
 */
public class Synchronized {

    public synchronized void parent() {
        System.out.println("Synchronized parent()");
    }

    public synchronized void methodA() {
        System.out.println("Synchronized methodA()");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodB() {
        System.out.println("Synchronized methodB()");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void staticMethodA() {
        System.out.println("Synchronized staticMethodA()");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void staticMethodB() {
        System.out.println("Synchronized staticMethodB()");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final Synchronized syn = new Synchronized();

        Runnable workA = new Runnable() {
            @Override
            public void run() {
                syn.methodA();
                Synchronized.staticMethodA();
            }
        };

        Runnable workB = new Runnable() {
            @Override
            public void run() {
                Synchronized.staticMethodB();
                syn.methodB();
            }
        };

        // 多线程下同时访问成员方法(锁对象)或静态方法(锁类)会发生互斥,
        // 多线程下分别访问成员方法(锁对象)或静态方法(锁类)不会发生互斥
        new Thread(workA).start();
        new Thread(workB).start();

    }

}
