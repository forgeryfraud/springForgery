package com.examly.springapp.service;
import com.examly.springapp.model.Employee;
import com.examly.springapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public List<Employee> getEmployeesContaining(String searchTerm) {
        return employeeRepository.findByNameContainingOrDesignationContaining(searchTerm, searchTerm);
    }

    public List<Employee> getEmployeesStartsWith(String name) {
        return employeeRepository.findByNameStartingWith(name);
    }
    public List<Employee> getEmployeesEndsWith(String name) {
        return employeeRepository.findByNameEndingWith(name);
    }
    public List<Employee> getEmployeesByDesignation(String designation) {
        return employeeRepository.findByDesignation(designation);
    }
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByNameContaining(name);
    }
}
