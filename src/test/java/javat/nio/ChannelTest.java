package javat.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class ChannelTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(new File("readandshow.txt"));
		FileChannel fc = fis.getChannel();
		
		//		SocketChannel channel = SocketChannel.open();
	}
}
