package javat;

public class BaseTest {

	public static void main(String[] args) {
		int x = 8, y = 2, z;
		z = ++x * y;
		System.out.println(z);
		
		z = x / y++;
		System.out.println(z);

		BaseTest a = new BaseTest();
		BaseTest b = a;
		System.out.print(a == b);

	}
}