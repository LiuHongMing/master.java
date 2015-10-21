package master.java.concurrent.demo;

/**
 * Interrupt方法并不能停止线程执行
 * 
 * https://docs.oracle.com/javase/7/docs/api/
 * 
 * If this thread is blocked in an invocation of the wait(), wait(long), or
 * wait(long, int) methods of the Object class, or of the join(), join(long),
 * join(long, int), sleep(long), or sleep(long, int), methods of this class,
 * then its interrupt status will be cleared and it will receive an
 * InterruptedException.
 */
public class WrongWayStopThread extends Thread {

	public static void main(String[] args) {
		WrongWayStopThread thread = new WrongWayStopThread();
		System.out.println("Starting thread...");
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Interrputing thread...");
		thread.interrupt();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Stopping thread...");
	}

	@Override
	public void run() {
		while (!this.isInterrupted()) {
			System.out.println("Thread is running...");
			long time = System.currentTimeMillis();
			// == Thread.sleep(1000)
			// while(System.currentTimeMillis() - time < 1000) {
			// // 减少屏幕输出的空循环
			// }

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
