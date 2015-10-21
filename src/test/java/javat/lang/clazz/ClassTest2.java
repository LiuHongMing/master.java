package javat.lang.clazz;

public class ClassTest2 {

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		/**
		 * The primitive Java types (boolean, byte, char, short, int, long,
		 * float, and double), and the keyword void are also represented as
		 * Class objects
		 */
		Class primitiveBoolean = boolean.class;
		Class primitiveByte = byte.class;
		Class primitiveChar = char.class;
		Class primitiveShort = short.class;
		Class primitiveInt = int.class;
		Class primitiveLong = long.class;
		Class primitiveFloat = float.class;
		Class primitiveDouble = double.class;
		Class classDouble = Double.class;
		System.out.println(primitiveDouble == classDouble);

		Class voidKeyword = void.class;
		Class voidClass = Void.class;
		System.out.println(voidKeyword == voidClass);
	}
}
