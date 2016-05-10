package javat.concurrent.locks;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * CLH������
 * <p/>
 * CLH���������ŵ��ǿռ临�Ӷȵͣ������n���̣߳�L������
 * ÿ���߳�ÿ��ֻ��ȡһ��������ô��Ҫ�Ĵ洢�ռ���O��L+n����
 * n���߳���n��myNode��L������L��tail����CLH��һ�ֱ��屻Ӧ������JAVA��������С�
 * Ψһ��ȱ������NUMAϵͳ�ṹ�����ܺܲ������ϵͳ�ṹ�£�ÿ���߳����Լ����ڴ棬
 * ���ǰ�������ڴ�λ�ñȽ�Զ�������ж�ǰ������locked�����ܽ�����ۿۣ�������SMPϵͳ�ṹ�¸÷����Ƿǳ���Ч�ġ�
 * һ�ֽ��NUMAϵͳ�ṹ��˼·��MCS��������
 */
public abstract class CLHLock2 implements Lock {

    private volatile QNode tail;

    private ThreadLocal<QNode> local;

    private static AtomicReferenceFieldUpdater<CLHLock2, QNode> UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(CLHLock2.class, QNode.class, "tail");

    public CLHLock2() {
        local = new ThreadLocal<QNode>() {
            @Override
            protected QNode initialValue() {
                return new QNode();
            }
        };
    }

    public void lock() {
        QNode node = local.get();
        QNode prev = UPDATER.getAndSet(this, node);
        if (prev != null) {
            while(prev.locked) {
            }
        }
        local.set(node);
    }

    public void unlock() {
        QNode node = local.get();
        if (!UPDATER.compareAndSet(this, node, null)) {
            node.locked = false;
        }
    }

    private static class QNode {
        volatile boolean locked = true;
    }
}
