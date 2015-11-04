package javat.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class CompletionServiceTest {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		final ExecutorService exec = Executors.newFixedThreadPool(10);

		CompletionService serv = new ExecutorCompletionService(exec);

		for (int index = 0; index < 5; index++) {
			final int NO = index;
			Callable downImg = new Callable() {
				@Override
				public Object call() throws Exception {
					Thread.sleep((long) (Math.random() * 10000));
					return "Downloaded Image " + NO;
				}
			};
			serv.submit(downImg);
		}

		// Thread.sleep(2 * 1000);

		System.out.println("Show web content");
		for (int i = 0; i < 5; i++) {
			Future task = serv.take();
			Object img = task.get();
			System.out.println(img);
		}
		System.out.println("End");

		exec.shutdown();
	}
}
