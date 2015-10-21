package javat.jvm.gc;

public class ReferenceCountingGC {

	public Object instance = null;

	private static final int _1M = 1024 * 1024;

	byte[] bigSize = new byte[2 * _1M];

	public static void main(String[] args) {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();

		objA.instance = objB;
		objB.instance = objA;

		objA = null;
		objB = null;

		System.gc();
	}
}
