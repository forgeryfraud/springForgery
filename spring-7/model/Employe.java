
Employee.java
package com.examly.springapp.model;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Employe {
    @Id
    private int id;
    private String name, designation;
    private double salary;
      public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}