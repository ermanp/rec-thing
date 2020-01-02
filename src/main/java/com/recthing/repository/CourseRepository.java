package com.recthing.repository;

import com.recthing.entity.Course;
import com.recthing.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    EntityManager em;

    public void entityManagerPersist(){
        // ##1##
        logger.info("PlayWithEntityManager - start");

        Course course = new Course("Spring MVC");

        em.persist(course);
        course.setName("Spring MVC Updated");

//      ##1##
    }

    public void entityManagerFlush(){
        Course course1 = new Course("Web Services");
        em.persist(course1);
        Course course2 = new Course("Angular JS");
        em.persist(course2);

        em.flush();

        course1.setName("Web Services Updated");
        em.flush();

        course2.setName("REACT Js");
        em.flush();
    }

    public void entityManagerDetach(){
        Course course1 = new Course("Web Services");
        em.persist(course1);
        Course course2 = new Course("Angular JS");
        em.persist(course2);

        em.flush();

        course1.setName("Web Services Updated");

        em.detach(course1);

     //   course1.setName("Web Services Updated");
     //   em.flush();

       // course2.setName("REACT Js");
     //   em.flush();

      //  em.detach(course1);
    }

    public void entityManagerClear(){
        Course course1 = new Course("Web Services");
        em.persist(course1);
        Course course2 = new Course("Angular JS");
        em.persist(course2);

        em.flush();

        em.clear();

        course1.setName("Web Services Updated");
        em.flush();

        course2.setName("REACT Js");
        em.flush();
    }

    public void entityManagerRefresh(){
        Course course1 = new Course("Web Services");
        em.persist(course1);
        Course course2 = new Course("Angular JS");
        em.persist(course2);
        em.flush();


        course1.setName("Web Services Updated");
        course2.setName("REACT Js");

        em.refresh(course1); // all changes after persist will be lost



    }

    public void addReviewsForCourse() {
        //get the course 10003
        Course course = findById(10003L);
        logger.info("course.getReviews() -> {}",course.getReviews());
        //add 2 reviews to it
        Review review = new Review("5", "Great");
        Review review2 = new Review("5", "Hatsoff");

        course.addReview(review);
        course.addReview(review2);

        // reviews is the owning side of the relationship, so the review has the course_id present, so i need to tell which course is assosiated with review
        review.setCourse(course);
        review2.setCourse(course);


        //save it to db
        em.persist(review);
        em.persist(review2);
    }

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }
}
