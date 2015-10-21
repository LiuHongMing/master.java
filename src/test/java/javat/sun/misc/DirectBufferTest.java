package javat.sun.misc;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class DirectBufferTest {

	public static void main(String[] args) {
		Unsafe unsafe = null;
		try {

			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);

			unsafe = (Unsafe) field.get(null);

		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		long oneHundred = 100;
		byte size = 1;

		/*
		 * 调用allocateMemory分配内存
		 */
		long memoryAddress = unsafe.allocateMemory(size);

		/*
		 * 将100写入到内存中
		 */
		unsafe.putAddress(memoryAddress, oneHundred);

		/*
		 * 内存中读取数据
		 */
		long readValue = unsafe.getAddress(memoryAddress);

		System.out.println("Val : " + readValue);
	}

}
