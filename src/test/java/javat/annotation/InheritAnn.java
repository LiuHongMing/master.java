package javat.annotation;

import java.lang.annotation.*;

public class InheritAnn {

    @Inherited // 允许子类继承父类中的注解
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface InheritUp {
    }

}
