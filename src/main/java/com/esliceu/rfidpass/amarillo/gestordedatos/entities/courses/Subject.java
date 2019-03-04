package com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses;


import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Student;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Asignatura")
public class Subject { //Assignatura tiene un curso.

    @Id
    private Integer code;

    private String description;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "curso_code")
    private Course course;

    @OneToMany(mappedBy = "asignatura")
    private Set<Student> students;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
