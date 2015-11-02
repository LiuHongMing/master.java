package javat.rtti;

import java.util.Random;

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitializationTest.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitializationTest {

    public static Random rand = new Random(47);

    public static void main(String[] args) {
        // Does not trigger initialization
        Class initable = Initable.class;
        System.out.println("After create Initable ref");
        // Does not trigger initialization
        System.out.println(Initable.staticFinal);
        // Does trigger initialization(rand() is static method)
        System.out.println(Initable.staticFinal2);

        // Does trigger initialization(not final)
        System.out.println(Initable2.staticNonFinal);

        try {
            Class initable3 = Class.forName("javat.rtti.Initable3");
        } catch (Exception e) {
            System.out.println("Can't find Initable3");
            System.exit(1);
        }

        System.out.println("After create Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
