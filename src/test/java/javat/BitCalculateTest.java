package javat;

public class BitCalculateTest {

    public static void main(String[] args) {
        int i = 256;
        i <<= 1;
        System.out.println(i);
        // ���ط���λ������=-1��0=0������=1
        System.out.println(Integer.signum(-10) + "," + Integer.signum(0) + "," + Integer.signum(10));
        System.out.println(Integer.toBinaryString(65536));
    }

}
