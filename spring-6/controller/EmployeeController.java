
package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Employee;
import com.examly.springapp.service.EmployeeService;

@RestController 
@RequestMapping("/employees") 
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) { this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) 
    { 
        Employee e=employeeService.saveEmployee(employee);
        if(e!=null)
        {
            return new ResponseEntity<>(e,HttpStatus.CREATED);
        }
        
        else{
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    
    @GetMapping
    public List<Employee> getAllEmployees() 
    {     
        return employeeService.getAllEmployees();
    }

    @GetMapping("/notContaining/{name}")
    public List<Employee> getEmployeesNotContainingName(@PathVariable String name) 
    {
         return employeeService.getEmployeesNotContainingName(name);
    }

    @GetMapping("/notContains/{designation}")
    public List<Employee> getEmployeesNotContainingDesignation(@PathVariable String designation) 
    {
        return employeeService.getEmployeesNotContainingDesignation(designation);
    }

    @GetMapping("/notLike/{searchTerm}")
    public List<Employee> getEmployeesNotLike(@PathVariable String searchTerm) 
    { 
        return employeeService.getEmployeesNotLike(searchTerm);
    }
}