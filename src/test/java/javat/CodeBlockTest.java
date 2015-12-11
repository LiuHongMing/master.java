package javat;

public class CodeBlockTest {

    public static class HelloA {

        // 静态块
        static {
            System.out.println("static A");
        }

        // 普通块
        {
            System.out.println("I am A");
        }

        // 构造块
        public HelloA() {
            System.out.println("Hello A");
            // 普通块
            {
                System.out.println("I am AAA");
            }
            // 同步块
            synchronized (HelloA.class) {

            }
        }

    }

    public static class HelloB extends HelloA {

        // 静态块
        static {
            System.out.println("static B");
        }

        // 普通块
        {
            System.out.println("I am B");
        }

        // 构造块
        public HelloB() {
            System.out.println("Hello B");
            // 普通块
            {
                System.out.println("I am BBB");
            }
            // 同步块
            synchronized (HelloB.class) {

            }
        }

    }

    public static void main(String[] args) {
        new HelloB();
    }

}
