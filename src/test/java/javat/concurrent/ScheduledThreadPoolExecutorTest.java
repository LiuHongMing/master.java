package javat.concurrent;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

		exec.scheduleAtFixedRate(new Runnable() {// 每隔一段时间就触发异常
					@Override
					public void run() {
						try {
							throw new RuntimeException("触发异常");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}, 1000, 5000, TimeUnit.MILLISECONDS);

		exec.scheduleAtFixedRate(new Runnable() {// 每隔一段时间打印系统时间，证明两者是互不影响的
					@Override
					public void run() {
						System.out.println(String.format(
								"%1$tY%1$tm%1$td_%1$tH%1$tM%1$tS", new Date()));
					}
				}, 1000, 2000, TimeUnit.MILLISECONDS);
	}
}
