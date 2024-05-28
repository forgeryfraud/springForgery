
package com.examly.springapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> { 
    List<Employee> findByNameNotContaining(String name); 
    List<Employee> findByDesignationNotContains(String designation);
    
}