
package com.examly.springapp.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.model.Student;
import com.examly.springapp.service.StudentService;
@RestController
public class StudentController {
    @Autowired
    StudentService ss;
    @PostMapping("/student")
    public ResponseEntity<Student> post(@RequestBody Student s)
    {
        Student obj=ss.create(s);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }
    @GetMapping("/student")
    public ResponseEntity<List<Student>> get()
    {
        return new ResponseEntity<>(ss.getall(),HttpStatus.OK);
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getbyid(@PathVariable("id") int id)
    {
        return new ResponseEntity<>(ss.getById(id),HttpStatus.OK);
    }
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> putMethod(@PathVariable("id") int id,@RequestBody Student s)
    {
        if(ss.update(id,s) == true)
        {
            return new ResponseEntity<>(s,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("student/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable int id)
    {
        boolean deleted = ss.delete(id);
        if (deleted) {
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with ID: " + id);
        }
    }
    @GetMapping("/student/sortedByName")
    public ResponseEntity<List<Student>> g()
    {
        List<Student> students = ss.sortbyname();
        return ResponseEntity.ok(students);
    }
    @GetMapping("/student/ageRange/{minAge}/{maxAge}")
    public ResponseEntity<List<Student>> getStudentsByAgeRange(@PathVariable int minAge, @PathVariable int maxAge) {
        List<Student> students = ss.getStudentsByAgeRange(minAge, maxAge);
        return ResponseEntity.ok(students);
    }
}