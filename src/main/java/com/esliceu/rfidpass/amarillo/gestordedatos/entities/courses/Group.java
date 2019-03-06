package com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.tools.Lector;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Student;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Grupo") // Grupos como el A, B
public class Group {

    @Id private Integer code;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_code")
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id")
    private Lector lector;

    @OneToMany(mappedBy = "group")
    private Set<Student> students;

    public Group() {}

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {this.code = code;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}