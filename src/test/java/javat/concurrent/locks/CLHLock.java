package javat.concurrent.locks;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CLH自旋锁
 *
 * CLH队列锁的优点是空间复杂度低（如果有n个线程，L个锁，
 * 每个线程每次只获取一个锁，那么需要的存储空间是O（L+n），
 * n个线程有n个myNode，L个锁有L个tail），CLH的一种变体被应用在了JAVA并发框架中。
 * 唯一的缺点是在NUMA系统结构下性能很差，在这种系统结构下，每个线程有自己的内存，
 * 如果前趋结点的内存位置比较远，自旋判断前趋结点的locked域，性能将大打折扣，但是在SMP系统结构下该法还是非常有效的。
 * 一种解决NUMA系统结构的思路是MCS队列锁。
 */
public abstract class CLHLock implements Lock {

    AtomicReference<QNode> tail;
    ThreadLocal<QNode> myNode;
    ThreadLocal<QNode> myPred;

    public CLHLock() {
        AtomicReference<QNode> tail = new AtomicReference<>(new QNode());
        ThreadLocal<QNode> myNode = new ThreadLocal<QNode>() {
            @Override
            protected QNode initialValue() {
                return new QNode();
            }
        };
        ThreadLocal<QNode> myPred = new ThreadLocal<QNode>() {
            @Override
            protected QNode initialValue() {
                return null;
            }
        };
    }

    public void lock() {
        QNode node = myNode.get();
        node.locked = true;
        QNode pred = tail.getAndSet(node);
        myPred.set(pred);
        while (pred.locked) {
        }
    }

    public void unlock() {
        QNode node = myNode.get();
        node.locked = false;
        myNode.set(myPred.get());
    }

    private static class QNode {
        volatile boolean locked;
    }
}
