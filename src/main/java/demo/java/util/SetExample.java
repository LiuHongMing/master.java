package demo.java.util;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class SetExample {

    public static void main(String[] args) {
        HashSet hashSet = new HashSet<String>();
        hashSet.add("name");
        hashSet.add("gender");
        hashSet.add("age");
        System.out.println(hashSet);

        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("name");
        linkedHashSet.add("gender");
        linkedHashSet.add("age");
        System.out.println(linkedHashSet);

    }

}
