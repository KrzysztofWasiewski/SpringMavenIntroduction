package pl.krisloves2code.SpringIntroduction.controller.service;


import pl.krisloves2code.SpringIntroduction.controller.model.Employee;
import pl.krisloves2code.SpringIntroduction.controller.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee get(long id) {
        return employeeRepository.findOne(id);
    }


    public void removeEmployee(long id) {
        employeeRepository.delete(id);
    }
}