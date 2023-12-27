package AnnotationValidation.Annotations.NameValidations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameImplementation implements ConstraintValidator<ValidName,String>
{
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context)
  {
    boolean isValid = !value.isEmpty() && value.matches("^[A-Z][a-z]+");
    if(!isValid)
    {
      context.disableDefaultConstraintViolation();
      if(value.length() > 10)
      {
        buildTemplate(context,"Name Can't Exceed Greater than 15Characters");
      }
      if(value.isBlank())
      {
        buildTemplate(context,"Name can't be Blank");
      }
      if(value.isEmpty())
      {
        buildTemplate(context,"Name can't be Empty");
      }
      if(value.substring(0,1).matches("^[a-z]"))
      {
          buildTemplate(context,"Name Should Start with UpperCase Character");
      }
      if(value.substring(0,1).matches("^[0-9]"))
      {
        buildTemplate(context,"Name Shouldn't Start with Numbers");
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
