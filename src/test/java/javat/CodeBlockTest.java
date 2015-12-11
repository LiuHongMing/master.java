package javat;

public class CodeBlockTest {

    public static class HelloA {

        // ��̬��
        static {
            System.out.println("static A");
        }

        // ��ͨ��
        {
            System.out.println("I am A");
        }

        // �����
        public HelloA() {
            System.out.println("Hello A");
            // ��ͨ��
            {
                System.out.println("I am AAA");
            }
            // ͬ����
            synchronized (HelloA.class) {

            }
        }

    }

    public static class HelloB extends HelloA {

        // ��̬��
        static {
            System.out.println("static B");
        }

        // ��ͨ��
        {
            System.out.println("I am B");
        }

        // �����
        public HelloB() {
            System.out.println("Hello B");
            // ��ͨ��
            {
                System.out.println("I am BBB");
            }
            // ͬ����
            synchronized (HelloB.class) {

            }
        }

    }

    public static void main(String[] args) {
        new HelloB();
    }

}
