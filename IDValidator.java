package AnnotationValidation.Annotations.IDValidations;

import AnnotationValidation.Annotations.IDValidations.IDValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IDValidation.class)
public @interface IDValidator
{
  String message() default "Invalid ID";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
