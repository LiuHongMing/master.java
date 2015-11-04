package javat.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class TestFutureTask2 {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		final ExecutorService exec = Executors.newFixedThreadPool(5);

		FutureTask<String> task = new FutureTask<String>(new Callable() {
			@Override
			public String call() throws Exception {
				Thread.sleep(5 * 1000);
				return "Other less important but longtime things.";
			}
		});

		exec.execute(task);
		Thread.sleep(3 * 1000);
		System.out.println("Let's do some things.");

		String result = task.get();
		System.out.println(result);

		exec.shutdown();
	}
}
