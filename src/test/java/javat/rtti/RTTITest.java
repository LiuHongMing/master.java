package javat.rtti;

interface HasBatteries {
}

interface WaterProof {
}

interface Shoots {
}

class Toy {

    public Toy() {
    }

    public Toy(int i) {
    }

}

/**
 * RTTI£¨Run-Time Type Information)
 */
public class RTTITest {

    public static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                ", is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class cc = null;

        try {
            cc = Class.forName("javat.rtti.FancyToy");
        } catch (Exception e) {
            System.exit(1);
        }
        printInfo(cc);

        for (Class face : cc.getInterfaces()) {
            printInfo(face);
        }

        Class up = cc.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Can't instantiation");
        } catch (IllegalAccessException e) {
            System.out.println("Can't access");
        }

        printInfo(obj.getClass());
    }

}
