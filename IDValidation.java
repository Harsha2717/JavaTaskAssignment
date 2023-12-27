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
        buildTemplate(context,"ID can't Exceed more than 6 characters");
      }
      if(value.length() < 3)
      {
        buildTemplate(context,"ID Can't be less than 3 Characters");
      }
      if(value.isEmpty())
      {
        buildTemplate(context,"ID can't be Empty");
      }
      if(value.isBlank())
      {
        buildTemplate(context,"ID can't be Blank");
      }
      if(value.substring(0,1).matches("^[a-z]") || value.substring(1,2).matches("^[a-z]"))
      {
        buildTemplate(context,"ID must have 2Characters as UpperCase");
      }
      if(value.substring(0,1).matches("^[A-Z]") && value.substring(1,2).matches("^[0-9]"))
      {
        buildTemplate(context,"ID Can only have 2Characters as UpperCase");
      }
      if(value.substring(0,1).matches("^[0-9]") ||value.substring(1,2).matches("^[0-9]"))
      {
        buildTemplate(context,"ID Can't start with Numbers");
      }
    }
    return isValid;
  }
  private boolean buildTemplate(ConstraintValidatorContext context,String message)
  {
    context.disableDefaultConstraintViolation();
    context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    return false;
  }
}
