package javat.lang;

import java.util.concurrent.TimeUnit;

public class Synchronized2Test extends Synchronized {

    // �����ͬ���������ܱ��̳�
    public void parent() {
        super.parent(); // ���ø����ͬ������Ҳ����ʵ��ͬ��
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
