package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    // AUTO_INCREMENT
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String enrollmentID;
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getEnrollmentID() {
        return enrollmentID;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student: " + name ;
    }

}
