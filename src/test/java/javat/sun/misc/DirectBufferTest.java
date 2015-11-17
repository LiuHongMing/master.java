package javat.sun.misc;

import java.lang.reflect.Field;

import master.java.UnsafeSupport;
import sun.misc.Unsafe;

public class DirectBufferTest {

	public static void main(String[] args) {
		Unsafe unsafe = UnsafeSupport.getInstance();

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
