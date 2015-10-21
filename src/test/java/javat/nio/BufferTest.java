package javat.nio;

import java.nio.ByteBuffer;

public class BufferTest {

	public static void main(String[] args) {
		byte[] array = new byte[128];
		ByteBuffer byteBuffer = ByteBuffer.wrap(array);
	}
}
