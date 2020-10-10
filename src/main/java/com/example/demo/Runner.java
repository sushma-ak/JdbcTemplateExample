package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Component
public class Runner implements ApplicationRunner {

	
	private StudentService studentService;
	
	
	@Autowired
	public Runner(StudentService studentService) {
		
		this.studentService = studentService;
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("Application Start to run");
		//saveStudentdata();
		//saveEmployeetdata();
		//updateEmployee();
		//deleteEmployee();
		getAllEmployeeData();
	}
	
	
	private void saveStudentdata()
	{
		Boolean isSaved=false;
		Student student=new Student();
		student.setId(106);
		student.setName("Ganapathi");
		
		isSaved=studentService.saveStudentdata(student);
		
		if(isSaved==true)
		{
			System.out.println("Data is saved sucessfully");
		}
		else
		{
			System.out.println("Data is not saved ");
		}
	}
	
	

	private void saveEmployeetdata()
	{
		Boolean isSaved=false;
		Employee employee=new Employee();
		employee.setId(106);
		employee.setFirst_name("kalasugana");
		employee.setLast_name("kurdekar");
		employee.setEmail("kalasugana@gmail.com");
		
		isSaved=studentService.saveEmployeedata(employee);
		
		if(isSaved==true)
		{
			System.out.println("Employee Data is saved sucessfully");
		}
		else
		{
			System.out.println("Data is not saved ");
		}
	}

	
	
	
	 private void updateEmployee() {
	        boolean isSaved = false;
	        Employee employee=new Employee();

	        employee.setFirst_name("sushma");;
	        employee.setLast_name("Kurdekar@123");
	        employee.setEmail("kala@123gmail.com");

	        isSaved = studentService.updateEmployeeData(105, employee);

	        if (isSaved) {
	            System.out.println("Data Updated Successfully");
	        } else {
	            System.out.println("Data not Updated");
	        }
	    }

	 
	 private void deleteEmployee() {
	        boolean isSaved = false;
	       

	        isSaved = studentService.deleteEmployeeData(105);
	        if (isSaved) {
	            System.out.println("Data delated Successfully");
	        } else {
	            System.out.println("Data not deleted");
	        }
	    }
	
	
	
	
	private void getAllEmployeeData()
	{
		List<Employee> ls=studentService.readEmployeeData();
		for(Employee data:ls)
		{
			System.out.println(data);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
