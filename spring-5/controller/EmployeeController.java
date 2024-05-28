
package com.examly.springapp.controller;
import com.examly.springapp.model.Employee;
import com.examly.springapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }
    @GetMapping("/containing/{searchTerm}")
    public ResponseEntity<List<Employee>> getEmployeesContaining(@PathVariable String searchTerm) {
        List<Employee> employees = employeeService.getEmployeesContaining(searchTerm);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/startsWith/{name}")
    public ResponseEntity<List<Employee>> getEmployeesStartsWith(@PathVariable String name) {
        List<Employee> employees = employeeService.getEmployeesStartsWith(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/endsWith/{name}")
    public ResponseEntity<List<Employee>> getEmployeesEndsWith(@PathVariable String name) {
        List<Employee> employees = employeeService.getEmployeesEndsWith(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
   @GetMapping("/contains/{designation}")
    public ResponseEntity<List<Employee>> getEmployeesByDesignation(@PathVariable String designation) {
        List<Employee> employees = employeeService.getEmployeesByDesignation(designation);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/isContaining/{name}")
    public ResponseEntity<List<Employee>> getEmployeesByName(@PathVariable String name) {
        List<Employee> employees = employeeService.getEmployeesByName(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}