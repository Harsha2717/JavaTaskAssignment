package AnnotationValidation.ServiceLayer;

import AnnotationValidation.Model.Employee;
import AnnotationValidation.RepositoryLayer.DBRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService
{
  @Autowired
  DBRepository repository;

  public void addEmployee(Employee employee)
  {
    repository.save(employee);
  }

  public Employee getEmployee(int id)
  {
    return repository.findById(id).get();
  }

  public List<Employee> getAllEmployees ()
  {
    return repository.findAll();
  }

}
