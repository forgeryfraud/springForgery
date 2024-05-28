
package com.examly.springapp.model;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Student {
    @Id
    int id;
    String name;
    int age;
    String address,department;
    public Student(){}
    public Student(int id, String name, int age, String address, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.department = department;
    }
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }  
}