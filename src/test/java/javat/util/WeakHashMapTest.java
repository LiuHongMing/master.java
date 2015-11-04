package javat.util;

import org.junit.Test;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {

    @Test
    public void testDemo() throws Exception {
        Map wmap = new WeakHashMap();
        //key为没有引用的对象
        wmap.put(new String("英语"), "良好");
        wmap.put(new String("数学"), "中等");
        wmap.put(new String("语文"), "及格");

        //key为引用的字符串常量
        wmap.put("java", "优秀");

        //输出四个键值对
        System.out.printf("contains：%s\n", wmap);

        //通知系统进行垃圾回收
        System.gc();
        System.runFinalization();

        //回收掉三个，输出一个键值对
        System.out.printf("contains：%s\n", wmap);
    }
}
