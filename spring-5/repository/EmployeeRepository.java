
package com.examly.springapp.repository;
import com.examly.springapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByNameContainingOrDesignationContaining(String name, String designation);
    List<Employee> findByNameStartingWith(String name);
    List<Employee> findByNameEndingWith(String name);
    List<Employee> findByDesignation(String designation);
    List<Employee> findByNameContaining(String name);
}