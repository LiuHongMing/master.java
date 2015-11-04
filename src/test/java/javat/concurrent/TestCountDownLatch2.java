package com.jason.test.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch2 {

	final ExecutorService exec = Executors.newFixedThreadPool(5);

	public static void main(String[] args) {
		TestCountDownLatch2 cdl = new TestCountDownLatch2();
		// cdl.execute(1, 99);

		TestCountDownLatch2 cdl2 = new TestCountDownLatch2();
		// cdl2.execute(2, 99);

		final int count_bit = 29;

		System.out.println(-1 << count_bit);
		System.out.println(0 << count_bit);
		System.out.println(1 << count_bit);
		System.out.println(2 << count_bit);
		System.out.println(3 << count_bit);
		System.out.println(count_bit);

		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(-536870912));
		String s = "10011100";
	}

	public void execute(final int idx, final int count) {
		long start = System.currentTimeMillis();
		int n = 5;
		final CountDownLatch doneSignal = new CountDownLatch(n);
		for (int i = 0; i < n; i++) {
			exec.execute(new Runnable() {

				@Override
				public void run() {
					String threadname = Thread.currentThread().getName();
					for (int i = 0; i < count; i++) {
						// if (idx == 2)
						System.out.println(threadname + "=" + i);
					}
					doneSignal.countDown();
				}

			});
		}

		try {
			doneSignal.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("Used = " + (end - start));
	}
}
