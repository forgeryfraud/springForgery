
package com.examly.springapp.repository;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.examly.springapp.model.Employee;
public interface EmployeeRepo extends JpaRepository<Employee,Integer>
{
    List<Employee> findByHireDate(Date hireDates);
    @Query("SELECT SUBSTRING(e.name, 1, 3) FROM Employee e")
    List<String> findFirstThreeCharactersOfAllNames();
}