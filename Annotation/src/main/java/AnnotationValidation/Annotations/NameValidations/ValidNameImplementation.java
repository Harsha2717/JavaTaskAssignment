package AnnotationValidation.Annotations.NameValidations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameImplementation implements ConstraintValidator<ValidName,String>
{
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context)
  {
    boolean isValid = !value.isEmpty() && !value.isBlank() && value.matches("^[A-Z][a-z]+");
    if(!isValid) {
      context.disableDefaultConstraintViolation();
      if(value.length() > 10)
      {
        context.buildConstraintViolationWithTemplate("Name Can't Exceed Greater than 15Characters").addConstraintViolation();
        return false;
      }
      if(value.isBlank())
      {
        context.buildConstraintViolationWithTemplate("Name can't be Blank").addConstraintViolation();
        return false;
      }
      if(value.isEmpty())
      {
        context.buildConstraintViolationWithTemplate("Name can't be Empty").addConstraintViolation();
        return false;
      }
      if(value.substring(0,1).matches("^[a-z]"))
      {
          context.buildConstraintViolationWithTemplate("Name Should Start with UpperCase Character").addConstraintViolation();
          return false;
      }
      if(value.substring(0,1).matches("^[0-9]"))
      {
        context.buildConstraintViolationWithTemplate("Name Shouldn't Start with Numbers").addConstraintViolation();
        return false;
      }
    }
    return isValid;
  }
}
