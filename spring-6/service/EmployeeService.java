
package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Employee;
import com.examly.springapp.repository.EmployeeRepo;

@Service
public class EmployeeService 
{

    @Autowired
    EmployeeRepo employeeRepo;
    public EmployeeService(EmployeeRepo employeeRepo) { this.employeeRepo = employeeRepo;
    }
    public Employee saveEmployee(Employee employee) 
    { 
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() 
    { 
        return employeeRepo.findAll();
    }

    public List<Employee> getEmployeesNotContainingName(String name) 
    { 
        return employeeRepo.findByNameNotContaining(name);
    }
    
    public List<Employee> getEmployeesNotContainingDesignation(String designation) 
    { 
        return employeeRepo.findByDesignationNotContains(designation);
    }

    public List<Employee> getEmployeesNotLike(String searchTerm) 
    {
        return employeeRepo.findByNameNotContaining(searchTerm);
}
}
