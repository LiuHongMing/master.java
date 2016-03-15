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

        System.out.println(square2(16));

        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-1 << 29));
        System.out.println(Integer.toBinaryString(-1 << 29 | 1));
    }

    public static int square2(int n) {
        if (n % 2 != 0) return 0;

        int x = 0;
        while (n > 1) {
            n = n >> 1;
            x++;
        }
        return x;
    }
}
