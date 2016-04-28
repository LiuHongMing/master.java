package demo.java.util;

import java.util.HashMap;
import java.util.Iterator;

public class MapExample {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name", "liuhongming");
        map.put("gender", "man");

        boolean hasKey = map.containsKey("name");
        boolean hasVal = map.containsValue("man");

        Iterable<String> iterable = map.values();
        Iterator<String> itr = iterable.iterator();
        while(itr.hasNext()) {
            String val = itr.next();
            System.out.println(val);
        }
        String val = map.remove("name");
        System.out.println(val);

    }
}
