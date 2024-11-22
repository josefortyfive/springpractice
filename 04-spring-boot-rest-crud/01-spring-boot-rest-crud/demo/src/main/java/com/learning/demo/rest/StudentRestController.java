package com.learning.demo.rest;

import com.learning.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void loadData(){

        students = new ArrayList<>();
        students.add(new Student("Maria", "Elena"));
        students.add(new Student("James", "Mark"));
        students.add(new Student("Mike", "Jordan"));

    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    // define endpoint or "/student/{studentId}" - return student at index


    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if((studentId >= students.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student Id not found - "+studentId);
        }
        return students.get(studentId);
    }

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        // create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Add another exception hander ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        // create a StudentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        // error.setMessage("Not a valid input"); -- This is of an custom input
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
