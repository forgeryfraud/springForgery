package com.examly.springapp.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.model.Employee;
import com.examly.springapp.service.EmployeeService;
@RestController
public class EmployeeController {
    @Autowired 
    EmployeeService es;
    @PostMapping("/employees")
    public ResponseEntity<Employee> add(@RequestBody Employee ee)
    {
        Employee obj = es.add(ee);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAll()
    {
        List<Employee> obj = es.getAll();
       return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id)
    {
        Employee obj = es.getById(id);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @GetMapping("/employees/groupBy/{attribute}")
    public Map<String, List<Employee>> groupByAttribute(@PathVariable String attribute) {
        return es.groupByAttribute(attribute);
    }
    @GetMapping("/employees/findBy/{attribute}")
    public List<Employee> findByAttribute(@PathVariable String attribute, @RequestParam("value") String value) {
        return es.findByAttribute(attribute, value);
    }
    @GetMapping("/employees/salaryRange")
    public List<Employee> findBySalaryRange(@RequestParam("minSalary") double minSalary,
                                            @RequestParam("maxSalary") double maxSalary) {
        return es.findBySalaryRange(minSalary, maxSalary);
    }
}

