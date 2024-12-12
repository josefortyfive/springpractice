package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model model){

        // get the employee from db
        List<Employee> employeeList = employeeService.findAll();

        // add to the spring model
        model.addAttribute("employees", employeeList);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        // create model attribute

        Employee employeeList = new Employee();
        model.addAttribute("employeeList", employeeList);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int Id, Model model){
        // get the employee from the service
        Employee employee = employeeService.findById(Id);

        // set employee in the middle to prepopulate the form
        model.addAttribute("employeeList", employee);

        // send over to our form
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployees(@ModelAttribute("employeeList") Employee employee){
        // save the employee
        employeeService.save(employee);


        // use a redirect to prevent duplicate submission
        return "redirect:/employees/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int Id){
        // delete the employee
        employeeService.deleteById(Id);
        
        // redirect to the main page
        return "redirect:/employees/list";
    }
}
