package javat;

public class UnSignedTest {

	public static void main(String[] args) {
		int unsigned = 5;
		int minus = ~unsigned + 1;
		
		System.out.println(minus);
	}
}
