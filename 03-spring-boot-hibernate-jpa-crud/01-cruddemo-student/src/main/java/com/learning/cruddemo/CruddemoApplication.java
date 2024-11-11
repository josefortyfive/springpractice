package com.learning.cruddemo;

import com.learning.cruddemo.dao.StudentDAO;
import com.learning.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudent(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create multiple Student
		System.out.println("Create new student objects... ");
		Student tempStudent1 = new Student("John", "Doe", "john@gmail.com");
		Student tempStudent2 = new Student("Mike", "Jordan", "mike@gmail.com");
		Student tempStudent3 = new Student("Mary", "Apple", "apple@gmail.com");

		// save the student object
		System.out.println("Saving the student ... ");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Successfully saved!");

	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Create new student object... ");
		Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");

		// save the student object

		System.out.println("Saving the student ..");
		studentDAO.save(tempStudent);

		// display id of the saved student

		System.out.println("Save student. Generated id: "+tempStudent.getId());
	}
}
