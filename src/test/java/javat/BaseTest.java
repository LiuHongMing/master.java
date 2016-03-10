package javat;

public class BaseTest {

    public static void main(String[] args) {
        int x = 8, y = 2, z;
        z = ++x * y;
        System.out.println("z=" + z + ",x=" + x + ",y=" + y);

        z = x / y++;
        System.out.println("z=" + z + ",x=" + x + ",y=" + y);

        BaseTest a = new BaseTest();
        BaseTest b = a;
        System.out.println(a == b);

        System.out.println("abc" == "abc");

        System.out.println(0x7FFFFFFF);
        System.out.println(0xFFFFFFFF);
    }
}
