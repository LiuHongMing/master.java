package com.jason.test.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier3 {
	public static void main(String[] args) {
		float[][] data = { { 0.1f, 0.2f }, { 0.3f, 0.4f }, { 0.5f, 0.5f },
				{ 0.1f, 0.2f }, { 0.3f, 0.4f }, { 0.5f, 0.5f }, { 0.1f, 0.2f },
				{ 0.3f, 0.4f }, { 0.5f, 0.5f }, { 0.1f, 0.2f }, { 0.3f, 0.4f },
				{ 0.5f, 0.5f }, { 0.1f, 0.2f }, { 0.3f, 0.4f }, { 0.5f, 0.5f },
				{ 0.1f, 0.2f }, { 0.3f, 0.4f }, { 0.5f, 0.5f }, { 0.1f, 0.2f },
				{ 0.3f, 0.4f }, { 0.5f, 0.5f }, { 0.1f, 0.2f }, { 0.3f, 0.4f },
				{ 0.5f, 0.5f }, { 0.1f, 0.2f }, { 0.3f, 0.4f }, { 0.5f, 0.5f },
				{ 0.1f, 0.2f }, { 0.3f, 0.4f }, { 0.5f, 0.5f } };
		new Solver(data);
	}
}

class Solver {
	final int N;

	final float[][] data;

	final CyclicBarrier cb;

	// 存储所有Runnable对象
	List<Worker> workers;

	float value;

	public Solver(float[][] matrix) {
		data = matrix;
		N = matrix.length;
		cb = new CyclicBarrier(N, new Runnable() {
			// 最后一个worker执行结束之后会进入以下的合并计算逻辑中。
			public void run() {
				for (Worker woker : workers) {
					value += woker.getResult();
				}
				System.out.println("\nFinal result: " + value + "\n");
			}
		});
		workers = new ArrayList<Worker>();
		for (int i = 0; i < N; ++i) {
			Worker worker = new Worker(i);
			workers.add(worker);
			new Thread(worker).start();
		}

	}

	class Worker implements Runnable {
		int rowNum;
		float result;

		public Worker(int rowNum) {
			this.rowNum = rowNum;
		}

		public void run() {
			for (int i = 0; i < data[rowNum].length; ++i) {
				result += data[rowNum][i];
			}
			System.out.println("rowNum:" + rowNum + ",result: " + result);
			try {
				cb.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				return;
			}
			System.out.println("rowNum:" + rowNum + " wake up...");
		}

		float getResult() {
			return result;
		}

	}

	float getValue() {
		return this.value;
	}
}
