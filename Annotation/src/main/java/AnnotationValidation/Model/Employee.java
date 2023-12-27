package AnnotationValidation.Model;

import AnnotationValidation.Annotations.IDValidations.IDValidator;
import AnnotationValidation.Annotations.NameValidations.ValidName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.GroupSequence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee_Table")
@GroupSequence({Employee.class, IDValidator.class, ValidName.class})
public class Employee
{
  @Id
  @IDValidator(message = "Invalid ID provided.",groups = IDValidator.class)
  private String id;

  @ValidName(message = "Name is not Valid.",groups = ValidName.class)
  private String Name;

}
