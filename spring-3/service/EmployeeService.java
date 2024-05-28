
package com.examly.springapp.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Employee;
import com.examly.springapp.repository.EmployeeRepo;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo er;
    public Employee postd(Employee emp) {
        return er.save(emp);
    }
    public List<Employee> getd() {
        return er.findAll();
    }
    public Optional<Employee> gettd(int id) {
        return er.findById(id);
    }
    public List<Employee> getttd(String hireDate) throws ParseException {
        Date hireDates = new SimpleDateFormat("yyyy-MM-dd").parse(hireDate);
        return er.findByHireDate(hireDates);
    }
    public List<String> gettttd() {
        return er.findFirstThreeCharactersOfAllNames();
    }
}

