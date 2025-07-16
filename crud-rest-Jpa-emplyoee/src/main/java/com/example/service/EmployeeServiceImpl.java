package com.example.service;

import com.example.dao.EmployeeRepositry;
import com.example.exception.EmployeeNotFoundException;
import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepositry employeeRepositry;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepositry theEmployeeDAO){
        employeeRepositry = theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll() {

        return employeeRepositry.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepositry.findById(theId);
        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }else{
            throw new EmployeeNotFoundException("Did not find emp id "+ theId);
        }
        return theEmployee;
    }
    @Override
    public Employee save(Employee employee) {
        return employeeRepositry.save(employee);
    }
    @Override
    public Employee deleteById(int theId) {
        employeeRepositry.deleteById(theId);
        return null;
    }
}
