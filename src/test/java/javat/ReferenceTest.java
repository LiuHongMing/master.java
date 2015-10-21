package javat;

import java.util.Vector;

public class ReferenceTest {

	public static void main(String[] args) {
		Vector v = new Vector();
		for (int i = 0; i < 100; i++) {
			Object obj = new Object();
			v.add(obj);
			obj = null;
		}
		int i = v.size();
		System.out.println(i);
	}
}
