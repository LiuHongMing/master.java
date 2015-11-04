package javat.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class TestFutureTask {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		final ExecutorService exec = Executors.newFixedThreadPool(5);
		Callable call = new Callable() {
			@Override
			public String call() throws Exception {
				Thread.sleep(5 * 1000);
				return "Other less important but longtime things.";
			}
		};

		Future<String> task = exec.submit(call);
		Thread.sleep(3 * 1000);
		System.out.println("Let's do important things.");

		String result = task.get();
		System.out.println(result);

		exec.shutdown();
	}
}
