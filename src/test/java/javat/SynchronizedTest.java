package javat;

/**
 * �ɲ鿴�ֽ������ּ����ķ�ʽ
 */
public class SynchronizedTest {
    private int i = 0;

    void incr() {
        synchronized (this) { // ������ (monitorenter,monitorexit)
            i++;
        }
    }

    synchronized void incr(int val) { // ͬ������ ACC_SYNCHRONIZED
        i++;
    }
}
