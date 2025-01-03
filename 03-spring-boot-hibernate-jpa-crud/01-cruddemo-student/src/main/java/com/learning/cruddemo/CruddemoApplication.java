package com.learning.cruddemo;

import com.learning.cruddemo.dao.StudentDAO;
import com.learning.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {

			createMultipleStudent(studentDAO);
			//queryForStudents(studentDAO);

			//queryForStudentByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("Deleting all Student...");

		int numberOfRowsDelete = studentDAO.deleteAll();


		System.out.println("Number of rows delete: "+numberOfRowsDelete);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;

		System.out.println("Deleting student with Id: " +studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId = 1;

		System.out.println("Getting the student Id: "+studentId);

		Student student = studentDAO.findById(studentId);

		System.out.println("Updating student ..");

		student.setLastName("Trump");
		studentDAO.update(student);

		System.out.println("Successfully updated the Student details!");
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {

		// get a list of student
		List<Student> theStudent = studentDAO.findByLastName("Benito");

		for(Student student : theStudent){

			if(student == null){
				System.out.println("No student found!");
			} else{
				System.out.println(student);
			}
		}

		// display list of students
	}

	private void queryForStudents(StudentDAO studentDAO) {

		List<Student> theStudent = studentDAO.findAll();

		for(Student student : theStudent){
			System.out.println(student);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object.... ");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

		System.out.println("Saving student..");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " +tempStudent.getId());

		System.out.println("\nRetrieve student id with: "+tempStudent.getId());
		Student studentId = studentDAO.findById(tempStudent.getId());

		System.out.println("Found the student: " + studentId);


	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create multiple Student
		System.out.println("Create new student objects... ");
		Student tempStudent1 = new Student("Dane", "Johnson", "dane@gmail.com");
		Student tempStudent2 = new Student("Mae", "Ana", "mae@gmail.com");
		Student tempStudent3 = new Student("Markie", "Benito", "markie@gmail.com");

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
