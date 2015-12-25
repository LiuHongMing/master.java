package javat.lang;

import java.util.concurrent.TimeUnit;

/**
 * ���Զ��߳��¶�ͬ������(��Ա��������̬����)�ķ��ʿ���
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

        // ���߳���ͬʱ���ʳ�Ա����(������)��̬����(����)�ᷢ������,
        // ���߳��·ֱ���ʳ�Ա����(������)��̬����(����)���ᷢ������
        new Thread(workA).start();
        new Thread(workB).start();

    }

}
