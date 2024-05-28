
EmployeeService.java
package com.examly.springapp.service;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Employee;
import com.examly.springapp.repository.EmployeeRepo;
@Service
public class EmployeeService {
       @Autowired
    EmployeeRepo er;
    public Employee add(Employee ee)
    {
        return er.save(ee);
    }
    public List<Employee> getAll()
    {
        return er.findAll();
    }
    public Employee getById(int id)
    {
        return er.findById(id).orElse(null);
    }
    public Map<String, List<Employee>> groupByAttribute(String attribute) {
        List<Employee> employees = er.findAll();
        return employees.stream()
                .collect(Collectors.groupingBy(emp -> {
                    switch (attribute) {
                        case "name":
                            return emp.getName();
                        case "designation":
                            return emp.getDesignation();
                        // Add more cases for other attributes if needed
                        default:
                            return "";
                    }
                }));
    }
   public List<Employee> findByAttribute(String attribute, String value) {
        switch (attribute) {
            case "name":
                return er.findByName(value);
            case "designation":
                return er.findByDesignation(value);
            default:
                return null;
        }
    }
    public List<Employee> findBySalaryRange(double minSalary, double maxSalary) {
        return er.findBySalaryBetween(minSalary, maxSalary);
    }
}