package AnnotationValidation.Annotations.NameValidations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidNameImplementation.class)
public @interface ValidName
{
  String message() default "Name is Invalid";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
