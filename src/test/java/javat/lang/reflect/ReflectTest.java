package javat.lang.reflect;

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
}

class Foo2 {
	private String name;
}
