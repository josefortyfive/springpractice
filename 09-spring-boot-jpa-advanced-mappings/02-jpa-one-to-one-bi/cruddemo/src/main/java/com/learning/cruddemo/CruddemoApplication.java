package com.learning.cruddemo;

import com.learning.cruddemo.dao.AppDAO;
import com.learning.cruddemo.entity.Instructor;
import com.learning.cruddemo.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			// createInstructor(appDAO);
			//findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor..." + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done deleting instructor.");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Find instructor id: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Instructor: "+tempInstructor);
		System.out.println("the associate instructorDetail only: "+tempInstructor.getInstructorDetail());

	}


	private void createInstructor(AppDAO appDAO) {


		// create the instructor
		//Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

		// create the instructor detail
		// InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luve 2 code!!!");

		// create the instructor
		Instructor tempInstructor = new Instructor("Edmar", "Canin", "edmar@java.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.codejava.com/youtube", "Coding!!!");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: This will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: "+tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}
