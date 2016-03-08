package demo.java;

import org.slf4j.LoggerFactory;
import sun.misc.Unsafe;

public class UnsafeSupport {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UnsafeSupport.class);

    private static final sun.misc.Unsafe UNSAFE = initUnsafe();

    private static sun.misc.Unsafe initUnsafe() {
        try {
            java.lang.reflect.Field f = sun.misc.Unsafe.class
                    .getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (sun.misc.Unsafe) f.get(null);
        } catch (Exception e) {
            LOGGER.error("Get Unsafe instance occur error", e);
        }
        return sun.misc.Unsafe.getUnsafe();
    }

    public static Unsafe getInstance() {
        return UNSAFE;
    }
}
