package javat.concurrent;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TestBlockingQueue {

	static long randomTime() {
		return (long) (Math.random() * 1000);
	}

	public static void main(String[] args) {
		final BlockingQueue<File> queue = new LinkedBlockingQueue<>(100);
		final ExecutorService exec = Executors.newFixedThreadPool(5);

		final File root = new File("D:\\task");
		final File exitFile = new File("");

		final AtomicInteger rc = new AtomicInteger();
		final AtomicInteger wc = new AtomicInteger();

		Runnable read = new Runnable() {
			@Override
			public void run() {
				scanFile(root);
				scanFile(exitFile);
			}

			public void scanFile(File file) {
				if (file.isDirectory()) {
					File[] files = file.listFiles(new FileFilter() {
						@Override
						public boolean accept(File pathname) {
							return pathname.isDirectory()
									|| pathname.getName().endsWith(".java");
						}
					});
					for (File one : files) {
						scanFile(one);
					}
				} else {
					try {
						int index = rc.incrementAndGet();
						System.out.println("Read():" + index + " "
								+ file.getPath());
						queue.put(file);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		};

		exec.submit(read);

		for (int index = 0; index < 4; index++) {
			final int NO = index;

			Runnable write = new Runnable() {
				String threadname = "Write:" + NO;

				@Override
				public void run() {
					while (true) {
						try {
							Thread.sleep(randomTime());
							int index = wc.incrementAndGet();
							File file = queue.take();
							if (file == exitFile) {
								queue.put(exitFile);
								break;
							}
							System.out.println(threadname + ":" + index + " "
									+ file.getPath());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

			};

			exec.submit(write);
		}

		exec.shutdown();
	}
}
