package javat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhongming on 12/28/2015.
 */
public class ListTest {

    public static void main(String[] args) {
        final List arrList = new ArrayList();

        Runnable add = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; ; ) {
                    //System.out.println("add=" + i);
                    arrList.add(++i);
                }
            }
        };

        Runnable get = new Runnable() {
            @Override
            public void run() {
                // 调用ArrayList.iterator()迭代会抛异常
                for (Object i : arrList) {
                    //System.out.println("get=" + i);
                }
            }
        };

        new Thread(add).start();
        new Thread(get).start();

    }

}
