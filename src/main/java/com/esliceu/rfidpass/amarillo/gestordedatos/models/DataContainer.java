package com.esliceu.rfidpass.amarillo.gestordedatos.models;

import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Course;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Group;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.courses.Subject;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.others.SchoolRoom;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.ProfessorSession;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.sessions.StudentSession;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Professor;
import com.esliceu.rfidpass.amarillo.gestordedatos.entities.users.Student;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class DataContainer {

    private Iterable<Course> courses;
    private Iterable<Group> groups;
    private Iterable<Professor> professors;
    private Iterable<ProfessorSession> professorSessions;
    private Iterable<Student> students;
    private List studentSessions;
    private Iterable<SchoolRoom> schoolRooms;
    private Iterable<Subject> subjects;
    private Long numberOfStudentSessions;

    @Value("${enpoint.pages}")
    String page;

    public Iterable<Course> getCourses() {
        return courses;
    }

    public void setCourses(Iterable<Course> courses) {
        this.courses = courses;
    }

    public Iterable<Group> getGroups() {
        return groups;
    }

    public void setGroups(Iterable<Group> groups) {
        this.groups = groups;
    }

    public Iterable<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(Iterable<Professor> professors) {
        this.professors = professors;
    }

    public Iterable<ProfessorSession> getProfessorSessions() {
        return professorSessions;
    }

    public void setProfessorSessions(Iterable<ProfessorSession> professorSessions) {
        this.professorSessions = professorSessions;
    }

    public Iterable<Student> getStudents() {
        return students;
    }

    public void setStudents(Iterable<Student> students) {
        this.students = students;
    }

    public Iterable<StudentSession> getStudentSessions() {
        return studentSessions;
    }

    public void setStudentSessions(List studentSessions) {
        this.studentSessions = studentSessions;
    }

    public Iterable<SchoolRoom> getSchoolRooms() {
        return schoolRooms;
    }

    public void setSchoolRooms(Iterable<SchoolRoom> schoolRooms) {
        this.schoolRooms = schoolRooms;
    }

    public Iterable<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Iterable<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Long getNumberOfStudentSessions() {
        return numberOfStudentSessions;
    }

    public void setNumberOfStudentSessions(Long numberOfStudentSessions) {
        this.numberOfStudentSessions = numberOfStudentSessions;
    }

    @Override
    public String toString() {
        return "DataContainer{" +
                "courses=" + courses +
                ", groups=" + groups +
                ", professors=" + professors +
                ", professorSessions=" + professorSessions +
                ", students=" + students +
                ", studentSessions=" + studentSessions +
                ", schoolRooms=" + schoolRooms +
                ", subjects=" + subjects +
                ", numberOfStudentSessions=" + numberOfStudentSessions +
                ", page='" + page + '\'' +
                '}';
    }
}

