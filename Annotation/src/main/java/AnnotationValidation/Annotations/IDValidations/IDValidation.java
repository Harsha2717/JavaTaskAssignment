package AnnotationValidation.Annotations.IDValidations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IDValidation implements ConstraintValidator<IDValidator,String>
{
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context)
  {
    boolean isValid = !value.isEmpty() && !value.isBlank()&& value.matches("^[A-Z]{2}[0-9]{2,4}");

    if(!isValid)
    {
      context.disableDefaultConstraintViolation();
      if(value.length() > 6)
      {
        context.buildConstraintViolationWithTemplate("ID can't Exceed more than 6 characters").addConstraintViolation();
        return false;
      }
      if(value.length() < 3)
      {
        context.buildConstraintViolationWithTemplate("ID Can't be less than 3 Characters").addConstraintViolation();
      }
      if(value.isEmpty())
      {
        context.buildConstraintViolationWithTemplate("ID can't be Empty").addConstraintViolation();
        return false;
      }

      if(value.isBlank())
      {
        context.buildConstraintViolationWithTemplate("ID can't be Blank").addConstraintViolation();
        return false;
      }
      if(value.substring(0,1).matches("^[a-z]") || value.substring(1,2).matches("^[a-z]"))
      {
        context.buildConstraintViolationWithTemplate("ID must have 2Characters as UpperCase").addConstraintViolation();
        return false;
      }
      if(value.substring(0,1).matches("^[A-Z]") && value.substring(1,2).matches("^[0-9]"))
      {
        context.buildConstraintViolationWithTemplate("ID must have 2 UpperCase Characters").addConstraintViolation();
        return false;
      }
      if(value.substring(0,1).matches("^[0-9]") ||value.substring(1,2).matches("^[0-9]"))
      {
        context.buildConstraintViolationWithTemplate("ID Can't start with Numbers").addConstraintViolation();
        return false;
      }

    }
    return isValid;
  }
}
