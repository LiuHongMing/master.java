package javat.lang;

public class ClassTest {

	public static void main(String[] args) {
		Foo1 foo1 = new Foo1();

		// 第一种表现形式
		Class cls1 = Foo1.class;

		// 第二种表现形式
		Class cls2 = foo1.getClass();

		System.out.println(cls1 == cls2);

		Class cls3 = null;
		try {
			// 第三种表现形式
			cls3 = Class.forName("javat.lang.Foo1"); // 类加载
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(cls2 == cls3);

		try {
			foo1 = (Foo1) cls1.newInstance();
			foo1.printMessage();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		/**
		 * 一切事物皆对象
		 * 
		 * 编译时刻的类加载是静态加载，运行时刻的类加载是动态加载
		 */
	}
}

class Foo1 {
	void printMessage() {
		System.out.println("This is " + this.getClass().getName());
	}
}
