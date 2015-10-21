package javat.nio;

import java.nio.channels.SelectionKey;

public class SelectorTest {

	public static void main(String[] args) {
		int interest = SelectionKey.OP_READ | SelectionKey.OP_ACCEPT;
		System.out.println(interest);
	}
}
