package javat.util;

import java.nio.charset.Charset;
import java.util.BitSet;

/**
 * 位集合
 * 
 * @author jason.liuhongming
 * 
 */
public class BitSetTest {

	public static void numeric() {
		BitSet xnbs = new BitSet();
		xnbs.set(6);
		System.out.printf("xnBs:length()=%d,size()=%d\n", xnbs.length(),
				xnbs.size());

		BitSet ynbs = new BitSet();
		ynbs.set(8);
		System.out.printf("ynBs:length()=%d,size()=%d\n", ynbs.length(),
				xnbs.size());

		xnbs.or(ynbs);
		System.out.printf("xnBs:length()=%d,size()=%d\n", xnbs.length(),
				xnbs.size());

		for (int i = 0; i < xnbs.size(); i++) {
			System.out.printf("numeric(%d:This's %s)\n", i, xnbs.get(i));
		}
	}

	public static void main(String[] args) {

		//numeric();
		
		String s = "liuhongming";
		String s2 = "jason.liuhongming";

		BitSet bit = new BitSet();
		for (int i = 0; i < s.length(); i++) {
			bit.set((int) s.charAt(i));
		}

		BitSet bits = BitSet.valueOf(s2.getBytes());

		System.out.println(bit);
		System.out.println(bits);

	    bit.andNot(bits);
		System.out.println(bit);

		int val = bit.cardinality();
		System.out.println(val);
	}
}
