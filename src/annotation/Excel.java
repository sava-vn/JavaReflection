package annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {
    int index() default  0;
    String names()  default "Sheet 1";
}
