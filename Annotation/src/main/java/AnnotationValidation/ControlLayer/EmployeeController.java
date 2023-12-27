package AnnotationValidation.ControlLayer;

import AnnotationValidation.Model.Employee;
import AnnotationValidation.ServiceLayer.EmployeeService;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Employee")
public class EmployeeController
{
  @Autowired
  EmployeeService service;
  @PostMapping("/AddEmployee")
  public ResponseEntity<?> CreateEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult)
  {
    if(bindingResult.hasErrors())
    {
      //FieldError error = bindingResult.getFieldError();
      List<String> errorList = new ArrayList<>();
      for(FieldError error : bindingResult.getFieldErrors())
      {
        errorList.add(error.getDefaultMessage());
      }
      return ResponseEntity.badRequest().body(errorList);
      //return ResponseEntity.badRequest().body(error.getDefaultMessage());
    }
    service.addEmployee(employee);
    return ResponseEntity.ok(employee);
  }

  @GetMapping("/GetAllEmployees")
  public ResponseEntity<?> getAllEmployee()
  {
    return ResponseEntity.ok(service.getAllEmployees());
  }
}
