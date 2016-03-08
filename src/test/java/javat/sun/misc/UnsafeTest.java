package javat.sun.misc;

import demo.java.AnalyzeTarget;
import demo.java.UnsafeSupport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnsafeSupport.class);

    @Test
    public void testFieldOffset() {
        Unsafe unsafe = UnsafeSupport.getInstance();

        Class targetClass = AnalyzeTarget.class;
        Field[] fields = targetClass.getDeclaredFields();
        LOGGER.info("fieldName:fieldOffset");
        // 获取属性偏移量，可以通过这个偏移量给属性设置
        for (Field f : fields) {
            long offset = unsafe.objectFieldOffset(f);
            LOGGER.info("{}:{}", f.getName(), offset);
        }

        // arg0, arg1, arg2, arg3 分别是目标对象实例，目标对象属性偏移量，当前预期值，要设的值
        // unsafe.compareAndSwapInt(arg0, arg1, arg2, arg3)
        AnalyzeTarget targetObj = new AnalyzeTarget();
        // 偏移量编译后一般不会变的,intParam这个属性的偏移量
        int intParamOffset = 32;
        // 给它设置,返回true表明设置成功
        // 基于有名的CAS算法的方法,并发包用这个方法很多
        LOGGER.info("{}\n{}", unsafe.compareAndSwapInt(targetObj, intParamOffset, 0, 6), targetObj.toString());
        // 比较失败
        LOGGER.info("{}\n{}", unsafe.compareAndSwapInt(targetObj, intParamOffset, 0, 10), targetObj.toString());
        // 验证上面是否设置成功,比较失败后不能设置成功,说明还是6
        // 比较成功后会设置成10,返回true
        LOGGER.info("{}\n{}", unsafe.compareAndSwapInt(targetObj, intParamOffset, 6, 10), targetObj.toString());
    }

}
