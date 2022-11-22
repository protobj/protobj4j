package io.protobj.core;

import io.protobj.definition.FieldType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ProtobjField {

    FieldType type() default FieldType.BOOL;

    int tag() default 0;

    String note() default "";

    boolean polymorphic() default false;
}
