package gof.singleton;

/**
 * 单例模式-双检锁
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
                    // 多线程环境下初始化阶段
                    // 存在线程安全问题
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }
}
