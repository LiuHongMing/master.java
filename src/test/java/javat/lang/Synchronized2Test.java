package javat.lang;

import java.util.concurrent.TimeUnit;

public class Synchronized2Test extends Synchronized {

    // 父类的同步方法不能被继承
    public void parent() {
        super.parent(); // 调用父类的同步方法也不能实现同步
        /*synchronized (this) {
            super.parent();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("********************");
        }*/
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------");
    }

    public static void main(String[] args) {

        final Synchronized2Test syn = new Synchronized2Test();

        Runnable workA = new Runnable() {
            @Override
            public void run() {
                syn.parent();
            }
        };

        Runnable workB = new Runnable() {
            @Override
            public void run() {
                syn.parent();
            }
        };

        new Thread(workA).start();
        new Thread(workB).start();
    }

}
