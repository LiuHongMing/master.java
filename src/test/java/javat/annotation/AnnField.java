package javat.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**   
 * @ClassName AnnField   
 * @Description TODO(自定义注解，用于字段、方法参数、局部变量)   
 * @author liuhongming  
 * @date Jan 10, 2015 11:39:20 AM   
 *      
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE })
public @interface AnnField {
	enum FieldType {
		STRING, INT
	};

	String scope() default "field,parameter,local_variable";

	String value() default "default value";
	
	FieldType[] type() default {};
}
