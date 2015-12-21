package javat.concurrent.locks;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CLH������
 *
 * CLH���������ŵ��ǿռ临�Ӷȵͣ������n���̣߳�L������
 * ÿ���߳�ÿ��ֻ��ȡһ��������ô��Ҫ�Ĵ洢�ռ���O��L+n����
 * n���߳���n��myNode��L������L��tail����CLH��һ�ֱ��屻Ӧ������JAVA��������С�
 * Ψһ��ȱ������NUMAϵͳ�ṹ�����ܺܲ������ϵͳ�ṹ�£�ÿ���߳����Լ����ڴ棬
 * ���ǰ�������ڴ�λ�ñȽ�Զ�������ж�ǰ������locked�����ܽ�����ۿۣ�������SMPϵͳ�ṹ�¸÷����Ƿǳ���Ч�ġ�
 * һ�ֽ��NUMAϵͳ�ṹ��˼·��MCS��������
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
