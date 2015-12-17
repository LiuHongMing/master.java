package javat;

/**
 * 可查看字节码区分加锁的方式
 */
public class SynchronizedTest {
    private int i = 0;

    void incr() {
        synchronized (this) { // 监视器 (monitorenter,monitorexit)
            i++;
        }
    }

    synchronized void incr(int val) { // 同步方法 ACC_SYNCHRONIZED
        i++;
    }
}
