package gof.singleton;

/**
 * ����ģʽ-˫����
 *
 * @author J.Ming
 *
 */
public class DoubleCheckLock {

    private static DoubleCheckLock instance = null;

    private DoubleCheckLock() {
    }

    public static DoubleCheckLock getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLock.class) {
                if (instance ==  null) {
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }
}
