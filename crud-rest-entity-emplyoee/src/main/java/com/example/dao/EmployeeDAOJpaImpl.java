package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class EmployeeDAOJpaImpl implements EmployeeDAO {
     //define feild for entityManager
    private EntityManager entityManager;

    // constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){

        entityManager=theEntityManager;
    }

    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
        //execute query and get res list
        List<Employee> emp = theQuery.getResultList();
        //return the res
        return emp;
    }
    public Employee findById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        return theEmployee;
    }
    public Employee save(Employee employee) {
        Employee dbEmp = entityManager.merge(employee);
        return dbEmp;
    }
    public void deleteById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        entityManager.remove(theEmployee);
    }
}
