package com.learning.springboot.cruddemo.rest;

import com.learning.springboot.cruddemo.dao.EmployeeDAO;
import com.learning.springboot.cruddemo.entity.Employee;
import com.learning.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    public EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee id not found " +employeeId);
        }

        return employee;
    }


    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        // also just incase they pass an id in JSON .... set id to 0
        // this is to force a save of new item ... instead of update

        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    // Add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.save(employee);

        return  dbEmployee;
    }

}
