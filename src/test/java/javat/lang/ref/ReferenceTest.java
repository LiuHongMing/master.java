package javat.lang.ref;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

class R {
    public String content;
}

public class ReferenceTest {

    @Test
    public void testWeakReference() throws Exception {
        R r = new R();
        r.content = "Hello, reference";

        WeakReference<R> weak = new WeakReference<>(r);
        r = null;

        int i = 0;
        while(weak.get() != null) {
            System.out.printf("Get content from object of WeakReference: %s, count: %d\n", weak.get().content, ++i);
            if (i % 10 == 0) {
                System.gc();
                System.out.println("System.gc() was invoked!");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        System.out.println("Object was cleared by JVM");
    }

    @Test
    public void testSoftReference() throws Exception {
        R r = new R();
        r.content = "Hello, reference";

        SoftReference<R> soft = new SoftReference<>(r);
        r = null;

        int i = 0;
        while(soft.get() != null) {
            System.out.printf("Get content from object of SoftReference: %s, count: %d\n", soft.get().content, ++i);
            if (i % 10 == 0) {
                System.gc();
                System.out.println("System.gc() was invoked!");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        System.out.println("Object was cleared by JVM");
    }

}
