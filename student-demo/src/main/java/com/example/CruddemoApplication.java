package com.sravExample.cruddemo;

import com.sravExample.cruddemo.dao.StudentDAO;
import com.sravExample.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner->{
			createStudent(studentDAO);
			createMutipleStudents(studentDAO);
			readStudent(studentDAO);
			queryForStudents(studentDAO);
		    queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
			deleteStudent(studentDAO);
			deleteAllRows(studentDAO);
		};
	}

	private void deleteAllRows(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("deleted row count: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId =3;
		System.out.println("Deleting Student"+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve stud based on id primaryKey
		int studentId=2;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);
		//change first name to "krish"
		System.out.println("Updating Student");
		myStudent.setFirst_name("Krish");
		//update the stud
		studentDAO.update(myStudent);
		//display
        System.out.println("Update Student"+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findbyFirstName("sujatha");
		//dis stud
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get list of stud
		List<Student> theStudents = studentDAO.findAll();
		//display list of stud
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a stud obj
		System.out.println("Creating new stud--");
		Student tempStudent = new Student("suzzu","irri","suzzuirri@23.com");
		//save the stud
		System.out.println("save the Stud--");
		studentDAO.save(tempStudent);
		//display id of saved
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+theId);
		//retrieve stud based on id
		System.out.println("Retrieving stud with id: "+theId);
		Student myStudent = studentDAO.findById(theId);
		//display stud
		System.out.println("Found the stud"+myStudent);

	}

	private void createMutipleStudents(StudentDAO studentDAO) {
		System.out.println("creating 3 new obj-----");
		Student tempStudent1= new Student("sravani","ioni","sravani@123.com");
		Student tempStudent2= new Student("sandhya","irri","sandhya@123.com");
		Student tempStudent3= new Student("sujatha","illi","sujatha@123.com");
		//save the stud obj
		System.out.println("Saving the Stud---");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student obj
		System.out.println("creating new obj-----");
		Student tempStudent = new Student("sravani","irri","sravani@123.com");
		//save the stud obj
		System.out.println("Saving the Stud---");
		studentDAO.save(tempStudent);
		//display id of saved stud
		System.out.println("Saved Stud. Generated id: "+tempStudent.getId());
	}
}
