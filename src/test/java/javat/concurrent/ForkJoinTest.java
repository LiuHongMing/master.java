package javat.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		CountTask countTask = new CountTask(1, 4);
		Future<Integer> result = pool.submit(countTask);
		try {
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}		
	}
}

class CountTask extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;

	private static int THRESHOLD = 2; // 阀值
	private int start;
	private int end;

	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		// 如果任务足够小就计算任务
		boolean canCompute = (end - start) < THRESHOLD;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			int middle = (start + end) / 2;

			CountTask leftTask = new CountTask(start, middle);
			CountTask rightTask = new CountTask(middle + 1, end);

			// 执行子任务
			leftTask.fork();
			rightTask.fork();

			// 等待子任务
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();

			// 合并任务值
			sum = leftResult + rightResult;
		}

		return sum;
	}
}
