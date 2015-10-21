package javat.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javat.annotation.AnnField.FieldType;

@AnnClass(scope = "class")
public class AnnotationTest {

	@AnnField(scope = "field")
	private String field;

	@AnnMethod(scope = "method")
	public void method() {
	}

	public void method(
			@AnnField(scope = "parameter", type = { FieldType.STRING }) String param,
			@AnnField("value=parameter2") String param2) {
		this.field = param;
	}

	public static void main(String[] args) {
//		boolean isAnnotationPresent = AnnotationTest.class
//				.isAnnotationPresent(AnnClass.class);
//		System.out.println(isAnnotationPresent);
//
//		Annotation clazzGetAnnotation = AnnotationTest.class
//				.getAnnotation(AnnClass.class);
//		System.out.println(clazzGetAnnotation);
//
//		Annotation[] clazzGetAnnotations = AnnotationTest.class
//				.getAnnotations();
//		System.out.println(clazzGetAnnotations[0]);
//
//		Annotation[] clazzDeclaredAnnotations = AnnotationTest.class
//				.getDeclaredAnnotations();
//		System.out.println(clazzDeclaredAnnotations[0]);
//
//		Field[] fields = AnnotationTest.class.getDeclaredFields();
//		for (Field myAnn : fields) {
//			AnnField anno = (AnnField) myAnn.getAnnotation(AnnField.class);
//			if (anno != null)
//				System.out.println(anno);
//		}

		Method[] methods = AnnotationTest.class.getDeclaredMethods();
		for (Method myAnn : methods) {
			if (!myAnn.getName().equals("main")) {
				Annotation[][] paramAnns = myAnn.getParameterAnnotations();
				int row = paramAnns.length;
				for (int i = 0; i < row; i++) {
					int col = paramAnns[i].length;
					for (int j = 0; j < col; j++) {
						AnnField annField = (AnnField) paramAnns[i][j];
						System.out.println(annField.scope());
						System.out.println(((FieldType[]) annField.type()).length);
						System.out.println(annField.value());
					}
				}
				AnnMethod annMethod = (AnnMethod) myAnn
						.getAnnotation(AnnMethod.class);
				if (annMethod != null)
					System.out.println(myAnn.getName() + "," + annMethod.scope());
			}
		}
	}
}
