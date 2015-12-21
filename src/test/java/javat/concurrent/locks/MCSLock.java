package javat.concurrent.locks;

import java.util.concurrent.atomic.AtomicReference;

/**
 * MCL������
 *
 * �ŵ���������NUMAϵͳ�ܹ���ȱ�����ͷ���Ҳ��Ҫ�����ȴ����ұ�CLH����д��CAS�Ȳ������ô�����
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
