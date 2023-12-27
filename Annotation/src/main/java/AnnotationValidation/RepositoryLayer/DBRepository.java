package AnnotationValidation.RepositoryLayer;

import AnnotationValidation.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBRepository extends JpaRepository<Employee,Integer>
{
}
