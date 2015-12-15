package javat;

public class BitCalculateTest {

    public static void main(String[] args) {
        int i = 256;
        i <<= 1;
        System.out.println(i);
        // 返回符号位：负数=-1，0=0，正数=1
        System.out.println(Integer.signum(-10) + "," + Integer.signum(0) + "," + Integer.signum(10));
        // 返回在指定的 int 值中最高位（最左边）的 1 位的位置的值
        System.out.println(Integer.toBinaryString(125) + ":" + Integer.highestOneBit(125));
        // 返回在指定的 int 值中最低位（最右边）的 1 位的位置的值
        System.out.println(Integer.toBinaryString(125) + ":" + Integer.lowestOneBit(125));
    }

}
