package javat.lang.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

public class ReflectTest {

	public static void main(String[] args) {
		Class cls = Foo2.class;
		// 字段
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true); 
			System.out.println(field.getName());
		}
		// 方法
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		// 类的泛型声明
		TypeVariable<?>[] typeVariables = cls.getTypeParameters();
		for (TypeVariable<?> typeVariable : typeVariables) {
			System.out.println(typeVariable.getName());
		}
	}

	@Test
	public void testField() throws Exception {
		Object staticObj = null;

		Field staticInstanceField = Foo2.class.getDeclaredField("thisObj");
		staticInstanceField.setAccessible(true);
		staticObj = (Foo2) staticInstanceField.get(null);
		System.out.println(staticObj);

		Field staticField = Foo2.class.getDeclaredField("name");
		staticField.setAccessible(true);
		staticObj = (String) staticField.get(null);
		System.out.println(staticObj);

		staticField = Foo2.class.getDeclaredField("age");
		staticField.setAccessible(true);
		staticObj = (int) staticField.get(null);
		System.out.println(staticObj);
	}
}

class Foo2 {
	private static String name;
	private static int age;
	private static final Foo2 thisObj;

	static {
		thisObj = new Foo2();
	}
}
