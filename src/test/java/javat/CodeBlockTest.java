package javat;

public class CodeBlockTest {

    public static class HelloA {

        // 静态代码块
        static {
            System.out.println("static A");
        }

        // 构造代码块，而且在new对象时，构造代码块优先构造方法执行
        {
            System.out.println("I am A");
        }

        // 构造方法
        public HelloA() {
            System.out.println("Hello A");
            // 普通代码块
            {
                System.out.println("I am AAA");
            }
            // 同步代码块
            synchronized (HelloA.class) {

            }
        }

    }

    public static class HelloB extends HelloA {

        // 静态代码块
        static {
            System.out.println("static B");
        }

        // 构造代码块，而且在new对象时，构造代码块优先构造方法执行
        {
            System.out.println("I am B");
        }

        // 构造方法
        public HelloB() {
            System.out.println("Hello B");
            // 普通代码块
            {
                System.out.println("I am BBB");
            }
            // 同步代码块
            synchronized (HelloB.class) {

            }
        }

    }

    public static void main(String[] args) {
        new HelloB();
    }

}
