package javat.lang;

public class ClassLoaderTest {
	
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		System.out.println(cl);

		ClassLoader cld = Thread.currentThread().getContextClassLoader();
		System.out.println(cld);
	}

}
