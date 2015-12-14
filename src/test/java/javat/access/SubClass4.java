package javat.access;

import javat.InheritTest;

/**
 * Created by liuhongming on 12/14/2015.
 */
public class SubClass4 extends InheritTest.SubClass3 {

    public static void main(String[] args) {
        SubClass4 sub4 = new SubClass4();
        System.out.println(sub4.sub1String + "," + sub4.sub3String);
    }
}
