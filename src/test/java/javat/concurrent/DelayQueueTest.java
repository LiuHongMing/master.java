package com.jason.test.concurrent;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        BlockingQueue<Task> queue = new DelayQueue<>();
        // TODO Auto-generated method stub
        for (int i = 0; i < 10; i++)
            new Thread(new ThreadProducer(queue)).start();
        for (int i = 0; i < 10; i++)
            new Thread(new ThreadConsumer(queue)).start();
    }
}

class Task implements Delayed {
    String name;
    long submitTime;

    Task(String taskName, long delayTime) {
        name = taskName;
        /*
		 * conver the time from MILLISECONDS to NANOSECONDS *
		 */
        submitTime = TimeUnit.NANOSECONDS.convert(delayTime,
                TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    public long getDelay(TimeUnit unit) {
        System.out.println("get delay");
        return unit.convert(submitTime - System.nanoTime(),
                TimeUnit.NANOSECONDS);
    }

    public int compareTo(Delayed o) {
        System.out.println("compareTo");
        Task that = (Task) o;
        return submitTime > that.submitTime ? 1
                : (submitTime < that.submitTime ? -1 : 0);
    }

    void doTask() {
        System.out.println("do task:" + name);
    }
}

class ThreadProducer implements Runnable {
    ThreadProducer(BlockingQueue<Task> queue) {
        this.queue = queue;
    }

    BlockingQueue<Task> queue;
    static int cnt = 0;

    public void run() {
        Task task;
        Random random = new Random(System.currentTimeMillis());
        while (true) {
            task = new Task("" + (cnt), random.nextInt() & 0xFFFF);
            cnt = (cnt + 1) & 0xFFFFFFFF;
            try {
                queue.put(task);
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadConsumer implements Runnable {
    ThreadConsumer(BlockingQueue<Task> queue) {
        this.queue = queue;
    }

    BlockingQueue<Task> queue;

    public void run() {
        Task task;
        while (true) {
            try {
                task = queue.take();
                task.doTask();
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

