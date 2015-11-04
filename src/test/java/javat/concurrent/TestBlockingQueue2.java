package javat.concurrent;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestBlockingQueue2 {

	public static void main(String[] args) {
		final BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(3);
		final Random random = new Random();

		class Producer implements Runnable {
			@Override
			public void run() {
				while (true) {
					int i = random.nextInt(100);
					try {
						queue.put(i); // 当队列达到容量时候，会自动阻塞的
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.printf("put:%s%n", i);
				}
			}
		}

		class Consumer implements Runnable {
			@Override
			public void run() {
				while (true) {
					try {
						Integer result = queue.take();// 当队列为空时，也会自动阻塞
						System.out.printf("take:%s%n", result);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		new Thread(new Producer()).start();
		new Thread(new Consumer()).start();
	}
}
