package com.recthing.repository;

import com.recthing.entity.Course;
import com.recthing.entity.Passport;
import com.recthing.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public void saveStudentWithPassport(){
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("Erman");
        student.setPassport(passport);
        em.persist(student);
    }


    public void insertHardcodedStudentAndCourse(){
        Student student = new Student("Jack");
        Course course = new Course("Microservices in 100 Steps");
        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);
        em.persist(student);
    }


}
