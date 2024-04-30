package se.yrgo.domain;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tutorId;
    private String name;
    private int salary;

    @OneToMany
    private List<Student> teachingGroup;

    public Tutor() {
    }

    public Tutor(String tutorId, String name, int salary) {
        this.tutorId = tutorId;
        this.name = name;
        this.salary = salary;
        this.teachingGroup = new ArrayList<Student>();
    }

    public void addStudent(Student newStudent) {
        this.teachingGroup.add(newStudent);
    }

    public List<Student> getTeachingGroup() {
/*         List<Student> unmodifiable = Collections.unmodifiableList(this.teachingGroup);
        return unmodifiable; */
        return Collections.unmodifiableList(this.teachingGroup);

    }

    public String getTutorId() {
        return tutorId;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Tutor [tutorId=" + tutorId + ", name=" + name + ", salary=" + salary + "]";
    }

}
