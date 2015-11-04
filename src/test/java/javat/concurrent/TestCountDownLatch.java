package javat.concurrent;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

	public static final int N = 10;

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch doneSignal = new CountDownLatch(N);
		CountDownLatch startSignal = new CountDownLatch(1);

		for (int i = 1; i <= N; i++) {
			new Thread(new Worker(i, doneSignal, startSignal)).start();
		}

		System.out.println("begin .....");
		startSignal.countDown();
		doneSignal.await();
		System.out.println("Ok");
	}

	static class Worker implements Runnable {
		private int beginIndex;
		private CountDownLatch doneSignal;
		private CountDownLatch startSignal;

		public Worker(int beginIndex, CountDownLatch doneSignal,
				CountDownLatch startSignal) {
			this.beginIndex = beginIndex;
			this.doneSignal = doneSignal;
			this.startSignal = startSignal;
		}

		@Override
		public void run() {
			try {
				String threadname = Thread.currentThread().getName();
				startSignal.await();
				beginIndex = (beginIndex - 1) * 10 + 1;
				for (int i = beginIndex; i < beginIndex + 10; i++) {
					System.out.println(threadname + "=" + i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				doneSignal.countDown();
			}

		}
	}
}
