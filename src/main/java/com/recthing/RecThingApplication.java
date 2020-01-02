package com.recthing;

import com.recthing.entity.FullTimeEmployee;
import com.recthing.entity.PartTimeEmployee;
import com.recthing.repository.CourseRepository;
import com.recthing.repository.EmployeeRepository;
import com.recthing.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class RecThingApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(RecThingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		courseRepository.entityManagerPersist();

	//	courseRepository.entityManagerFlush();

	//	courseRepository.entityManagerDetach();

	//	courseRepository.entityManagerClear();

	//	courseRepository.entityManagerRefresh();

	//	studentRepository.saveStudentWithPassport();

	//	courseRepository.addReviewsForCourse();

	//	studentRepository.insertHardcodedStudentAndCourse();

	//	employeeRepository.insert(new FullTimeEmployee("JAck",new BigDecimal("10000")));

	//	employeeRepository.insert(new PartTimeEmployee("JAck",new BigDecimal("50")));

	//	logger.info("All Employees -> {}", employeeRepository.retreiveAllEmployees());

	}
}
