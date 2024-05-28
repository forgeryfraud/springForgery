
package com.examly.springapp.controller;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.model.Employee;
import com.examly.springapp.service.EmployeeService;
@RestController
public class EmployeeController 
{
    @Autowired
    private EmployeeService es;
    @PostMapping("/employee")
    public ResponseEntity<?> postd(@RequestBody Employee emp)
    {
        try
        {
            return new ResponseEntity<>(es.postd(emp),HttpStatus.CREATED);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/employee")
    public ResponseEntity<?> getd()
    {
        try
        {
            return new ResponseEntity<>(es.getd(),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<?> gettd(@PathVariable int id)
    {
        try
        {
            return new ResponseEntity<>(es.gettd(id),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/employee/hired/{hireDate}")
    public ResponseEntity<?> getttd(@PathVariable String hireDate)
    {
        try
        {
            return new ResponseEntity<>(es.getttd(hireDate),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/employee/first-three-characters-of-name")
    public ResponseEntity<?> gettttd()
    {
        try
        {
            return new ResponseEntity<>(es.gettttd(),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}