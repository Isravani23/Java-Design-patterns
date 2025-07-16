package com.example.cruddemo.rest;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.ObjectName;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private ObjectMapper objectMapper;
    private EmployeeService employeeService;
    @Autowired
    public  EmployeeRestController(EmployeeService theEmployeeService, ObjectMapper theObjectMapper){
        employeeService=theEmployeeService;
        objectMapper=theObjectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee==null){
            throw new RuntimeException("Employee id not found "+employeeId);
        }
        return theEmployee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmp = employeeService.save(theEmployee);
        return dbEmp;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmp = employeeService.save(theEmployee);
        return dbEmp;
    }
    @PatchMapping("/employees/{employeeId}")
    public Employee  Employee(@PathVariable int employeeId, @RequestBody Map<String,Object> patchPayload){
        Employee temp = employeeService.findById(employeeId);
        if(temp == null){
            throw new RuntimeException("Emp id not found "+temp);
        }
        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Employee id not allowed in request body"+employeeId);
        }
        Employee patchedEmployee = apply(patchPayload,temp);
        Employee dbEmp = employeeService.save(patchedEmployee);
        return dbEmp;
    }

    private Employee apply(Map<String, Object> patchPayload, Employee temp) {
        //Convert emp object to a JSON obj Node
        ObjectNode employeeNode = objectMapper.convertValue(temp,ObjectNode.class);
        // Convert the patchpayload map to a JSON object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayload,ObjectNode.class);
        // merge the patch updates into the emp node
        employeeNode.setAll(patchNode);
        return objectMapper.convertValue(employeeNode, Employee.class);
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);
        if(tempEmployee==null){
            throw new RuntimeException("Employee id not found "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id "+employeeId;
    }

}
