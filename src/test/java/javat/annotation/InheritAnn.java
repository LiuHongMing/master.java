package javat.annotation;

import java.lang.annotation.*;

public class InheritAnn {

    @Inherited
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface InheritUp {}

}
