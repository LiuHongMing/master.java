package master.java.io.demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class FileConverter {

	public static String SRC_FILE_EXT = "amr";
	public static String DEST_FILE_EXT = "mp3";

	private static final ExecutorService asynService = Executors
			.newCachedThreadPool();

	public static void doArm2Mp3(String mp3Path, String armPath,
			byte[] armFileBytes, String uploadFileUrl) {
		ConvertTask convertTask = new ConvertTask(mp3Path, armPath,
				armFileBytes, uploadFileUrl);
		asynService.execute(convertTask);
	}

	static class ConvertTask implements Runnable {

		private String destPath;
		private String srcPath;
		private byte[] srcFileBytes;
		private String fileId;

		public ConvertTask(String dest, String src, byte[] srcBytes,
				String fileId) {
			this.destPath = dest;
			this.srcPath = src;
			this.srcFileBytes = srcBytes;
			this.fileId = fileId;
		}

		@Override
		public void run() {
			File srcFile = new File(srcPath);
			File destFile = new File(destPath);
			try {
				FileUtils.writeByteArrayToFile(srcFile, srcFileBytes);
			} catch (Exception e) {
			}

			try {
				java.lang.Runtime rt = Runtime.getRuntime();
				String command = "ffmpeg -i " + srcPath + " " + destPath;
				Process proc = rt.exec(command);
				int exitVal = proc.waitFor();
			} catch (Exception e) {
			}

			try {
				FileInputStream fis = new FileInputStream(destFile);
				byte[] fileBytes = IOUtils.toByteArray(fis);
			} catch (Exception e) {
			}

			FileUtils.deleteQuietly(srcFile);
			FileUtils.deleteQuietly(destFile);
		}
	}
}
