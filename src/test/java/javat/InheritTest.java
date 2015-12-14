package javat;

public class InheritTest
{
    public static void main(String[] args) {
        SubClass3 sub3 = new SubClass3();

        // ∏≤∏«SubClass1.sub1Int∑√Œ »®œﬁ
        // System.out.println(sub3.sub1Int);
    }

    public static class SubClass3 extends SubClass2 {
        int sub3Int = 300;
        private double sub3Double;
        public String sub3String;
    }
}

class SubClass1 {
    int sub1Int = 100;
    private double sub1Double;
    public String sub1String;
}

class SubClass2 extends SubClass1 {
    private int sub1Int = 200;
    private int sub2Int;
    double sub2Double;
}


