package javaV8;

import java.util.*;
import java.util.stream.Collectors;

public class EmpImp {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        Map<String,Long> gender = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        List<String> dep = employeeList.stream().map(Employee::getDepartment).toList();
        Map<String, Double> age = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge)));
        Optional<Employee> paid = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(gender+"\n"+dep+"\n"+age+"\n"+paid);
    }
}
