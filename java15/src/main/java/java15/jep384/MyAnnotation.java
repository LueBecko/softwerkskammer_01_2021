package java15.jep384;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * new ElementType to specify that the annotation is only allowed on records:
 * @Target(RECORD_COMPONENT)
 */
@Target(ElementType.FIELD)
public @interface MyAnnotation {
    
}
