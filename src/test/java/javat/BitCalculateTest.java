package javat;

public class BitCalculateTest {

    public static void main(String[] args) {
        int i = 256;
        i <<= 1;
        System.out.println(i);
        // ���ط���λ������=-1��0=0������=1
        System.out.println(Integer.signum(-10) + "," + Integer.signum(0) + "," + Integer.signum(10));
        // ������ָ���� int ֵ�����λ������ߣ��� 1 λ��λ�õ�ֵ
        System.out.println(Integer.toBinaryString(125) + ":" + Integer.highestOneBit(125));
        // ������ָ���� int ֵ�����λ�����ұߣ��� 1 λ��λ�õ�ֵ
        System.out.println(Integer.toBinaryString(125) + ":" + Integer.lowestOneBit(125));
    }

}
