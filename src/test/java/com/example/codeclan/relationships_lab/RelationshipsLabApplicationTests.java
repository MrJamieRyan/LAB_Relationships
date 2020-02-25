package com.example.codeclan.relationships_lab;

import com.example.codeclan.relationships_lab.models.Department;
import com.example.codeclan.relationships_lab.models.Employee;
import com.example.codeclan.relationships_lab.models.Project;
import com.example.codeclan.relationships_lab.repositories.DepartmentRepository;
import com.example.codeclan.relationships_lab.repositories.EmployeeRepository;
import com.example.codeclan.relationships_lab.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationshipsLabApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createDepartmentandEmployee(){
		Department department = new Department("Accounts");
		departmentRepository.save(department);

		Employee employee1 = new Employee("Boaty", "McBoatface", "32",
				department);
		employeeRepository.save(employee1);
	}

	@Test
	public void addEmployeesAndProjects(){
		Department department = new Department("Accounts");
		departmentRepository.save(department);

		Employee employee1 = new Employee("Boaty", "Mcboatface", "32",
				department);
		employeeRepository.save(employee1);

		Project project1 = new Project("Stationary Budget", 30);
		projectRepository.save(project1);

		project1.addEmployee(employee1);
		projectRepository.save(project1);

	}

}
