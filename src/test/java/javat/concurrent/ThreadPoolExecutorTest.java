package javat.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	private static int produceTaskSleepTime = 2;
	private static int consumeTaskSleepTime = 2000;
	private static int produceTaskMaxNumber = 10;

	public static void main(String[] args) {

		ThreadPoolExecutor exec = new ThreadPoolExecutor(2, 4, 3,
				TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
				new ThreadPoolExecutor.DiscardOldestPolicy());

		for (int i = 0; i < produceTaskMaxNumber; i++) {
			String task = "task@" + i;
			System.out.println("put " + task);
			exec.execute(new ThreadPoolTask(task));
			try {
				Thread.sleep(produceTaskSleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		exec.shutdown();
	}

	static class ThreadPoolTask implements Runnable {
		private String task;

		public ThreadPoolTask(String task) {
			this.task = task;
		}

		@Override
		public void run() {
			System.out.println("start .. " + task + "("
					+ Thread.currentThread().getName() + ")");
			try {
				Thread.sleep(consumeTaskSleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
