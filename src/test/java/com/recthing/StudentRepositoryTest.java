package com.recthing;

import com.recthing.entity.Student;
import com.recthing.repository.StudentRepository;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RecThingApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager em;

   /* @Test
    public void retrieveStudentAndPassportDetails(){
        Student student = em.find(Student.class, 2001L);
        logger.info("studend: "+student);
        logger.info("passport: "+student.getPassport());
    }*/

   //##71##
    @Test
    public void retrieveStudentAndPasswordDetailWithoutTransactional(){
        Student student = em.find(Student.class, 20001L);
        logger.info("studend: "+student);
        logger.info("passport: "+student.getPassport());

    }

    @Test
    @Transactional
    public void retrieveStudentAndPasswordDetailTransactional(){
        Student student = em.find(Student.class, 20001L);
        logger.info("studend: "+student);
        logger.info("passport: "+student.getPassport());

    }


    @Test
    @Transactional //transactional olmazsa coursesı fetchlemez
    public void retrieveStudentAndCourses(){
        Student student = em.find(Student.class, 20001L);
        logger.info("studend: "+student);
        logger.info("passport: "+student.getCourses());

    }
}
