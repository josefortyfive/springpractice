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


}
