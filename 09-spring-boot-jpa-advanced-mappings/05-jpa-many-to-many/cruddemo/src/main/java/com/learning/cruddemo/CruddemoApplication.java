package com.learning.cruddemo;

import com.learning.cruddemo.dao.AppDAO;
import com.learning.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			// createCourseAndStudent(appDAO);
			// findCourseAndStudents(appDAO);
			// findStudentAndCourses(appDAO);
			// addMoreCoursesForStudent(appDAO);
			// deleteCourse(appDAO);
			deleteStudent(appDAO);

		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Deleting student id: "+theId);

		appDAO.deleteStudentById(theId);

		System.out.println("Done deleting Student: "+theId);
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId = 2;

		Student student = appDAO.findStudentAndCoursesByStudentId(theId);

		// create more courses

		Course course = new Course("Rubik's Cube - How to Speed Cube");
		Course course1 = new Course("Dark Souls - Speed Run");

		// add course to student

		student.addCourse(course);
		student.addCourse(course1);

		System.out.println("Updating student: "+student);
		System.out.println("associated courses : " +student.getCourses());

		appDAO.update(student);

		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId = 2;

		Student student = appDAO.findStudentAndCoursesByStudentId(2);

		System.out.println("Loaded Student: "+student);
		System.out.println("Courses: "+student.getCourses());

		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId = 10;

		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Loaded course: "+tempCourse);
		System.out.println("Students: "+tempCourse.getStudents());

		System.out.println("Done!");

	}

	private void createCourseAndStudent(AppDAO appDAO) {

		// create a course
		Course course = new Course("Pacman - How To Score One Million");

		// create the students
		Student student1 = new Student("Mark", "Herras", "mark@gmail.com");
		Student student2 = new Student("Jennifer", "Lopez", "jen@gmail.com");

		// add students to the course]
		course.addStudent(student1);
		course.addStudent(student2);

		// save the course and associated students

		System.out.println("Saving the course: "+course);
		System.out.println("Associated student: "+course.getStudents());

		appDAO.save(course);

		System.out.println("Done!");
	}

	public void deleteCourseAndReviews(AppDAO appDAO){
		int theId = 10;

		System.out.println("Deleting course id: "+ theId);
		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		int theId = 10;
		Course course = appDAO.findCourseAndReviewsByCourseId(theId);

		// print the course
		System.out.println(course);

		// print the reviews

		System.out.println(course.getReview());
		System.out.println("DONE!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		// create a course
		Course course = new Course("Pacman - How to Score One Million Points!");

		// add some reviews
		course.addReview(new Review("Great Course.. loved it!"));
		course.addReview(new Review("Excellent Course!"));
		course.addReview(new Review("Good course!"));
		course.addReview(new Review("I Don't like this course"));

		// save the course ... and leverage the cascade all
		System.out.println("Saving the course..");
		System.out.println(course);
		System.out.println(course.getReview());

		appDAO.save(course);

		System.out.println("DONE!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Deleting course id: " +theId);

		appDAO.deleteCourseById(theId);

		System.out.println("DONE!");
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;

		// find the course
		System.out.println("Finding course id: "+theId);
		Course course = appDAO.findCourseById(theId);

		// update the course
		System.out.println("Updating course id: "+theId);
		course.setTitle("Basketball");

		appDAO.update(course);

		System.out.println("DONE!");



	}


	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id: "+theId);
		Instructor instructor = appDAO.findInstructorById(theId);

		// update the instructor
		System.out.println("Updating instructor id: " +theId);
		instructor.setLastName("TESTER");
		appDAO.update(instructor);

		System.out.println("DONE!");

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Finding instructor id: " +theId);

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " +tempInstructor);
		System.out.println("the associated courses: " +tempInstructor.getCourses());

		System.out.println("Done!");

	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding Instructor Id: " +theId);

		Instructor instructor = appDAO.findInstructorById(theId);
		System.out.println("Instructor:  "+instructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor Id: " +theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects

		instructor.setCourses(courses);
		System.out.println("the associated courses: " +instructor.getCourses());
		System.out.println("Done!");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding Instructor Id: " +theId);

		Instructor instructor = appDAO.findInstructorById(theId);
		System.out.println("Instructor:  "+instructor);
		System.out.println("The associated courses: " +instructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Susan", "Public", "susan@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.comW", "Gaming!!!");


		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Air Guitar - Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Master Class");

		// add Courses to Instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving instructor: " +tempInstructor);
		System.out.println("The courses: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done ..");


	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 3;
		System.out.println("Deleting instructor detail id: "+theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done ..");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int theId = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
		// print the instructor detail

		System.out.println("Instructor Detail: "+instructorDetail);

		// print the associated instructor
		System.out.println("Associated instructor: "+instructorDetail.getInstructor());

		System.out.println("Done..");

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
		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luve 2 code!!!");

		// create the instructor
		// Instructor tempInstructor = new Instructor("Edmar", "Canin", "edmar@java.com");

		// create the instructor detail
		// InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.codejava.com/youtube", "Coding!!!");

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
