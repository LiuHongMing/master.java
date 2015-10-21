package javat.lang;

import java.util.Iterator;
import java.util.Properties;

public class SystemTest {

	public static final String SUN_BOOT_CLASS_PATH = "sun.boot.class.path";
	public static final String JAVA_EXT_DIRS = "java.ext.dirs";
	public static final String JAVA_CLASS_PATH = "java.class.path";
	
	public static void main(String[] args) {
		Properties props = System.getProperties();

		for (Iterator iter = props.keySet().iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			System.out.println("key=" + key + ",value="
					+ props.getProperty(key));
		}
	}
}
