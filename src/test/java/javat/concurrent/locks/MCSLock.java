package javat.concurrent.locks;

import java.util.concurrent.atomic.AtomicReference;

/**
 * MCL自旋锁
 *
 * 优点是适用于NUMA系统架构，缺点是释放锁也需要自旋等待，且比CLH读、写、CAS等操作调用次数多
 */
public class MCSLock implements Lock {

    AtomicReference<QNode> tail;
    ThreadLocal<QNode> myNode;

    @Override
    public void lock() {
        QNode node = myNode.get();
        QNode pred = tail.getAndSet(node);
        if(pred != null) {
            node.locked = true;
            pred.next = node;
            while(node.locked) {}
        }
    }

    @Override
    public void unLock() {
        QNode node = myNode.get();
        QNode pred = tail.get();
        if (pred == null) {
            if(tail.compareAndSet(node, null)) {
                return;
            }

            while (node.next == null) {}
        }

        pred.next.locked = false;
        pred.next = null;
    }

    class QNode {
        boolean locked = false;
        QNode next = null;
    }

}
