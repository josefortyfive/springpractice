package com.learning.springboot.thymeleafdemo.controller;

import com.learning.springboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showForm(Model model){

        // create a new student object
        Student student = new Student();

        // add student object to the model
        model.addAttribute("student", student);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student){

        System.out.println("Student: " +student.getFirstName()+ " " +student.getLastName());
        
        return "student-confirmation";
    }
}
