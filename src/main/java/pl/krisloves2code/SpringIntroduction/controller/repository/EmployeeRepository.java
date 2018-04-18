package pl.krisloves2code.SpringIntroduction.controller.repository;


import pl.krisloves2code.SpringIntroduction.controller.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}