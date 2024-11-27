package com.learning.springboot.cruddemo.dao;

import com.learning.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entityManager

    public EntityManager entityManager;

    // setup Constructor injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result l;ist
        List<Employee> employees = theQuery.getResultList();

        // return the results

        return employees;
    }

    @Override
    public Employee findById(int employeeId) {

        // get employee
        Employee employee = entityManager.find(Employee.class, employeeId);

        // return employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {

        Employee employeeSave = entityManager.merge(employee);

        // return the employeeSave
        return employeeSave;
    }

    @Override
    public void delete(int employeeId) {

        Employee employee = entityManager.find(Employee.class, employeeId);

        entityManager.remove(employee);
    }
}
