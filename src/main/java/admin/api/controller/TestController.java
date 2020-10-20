package admin.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import admin.api.model.EmployeeExample;


@CrossOrigin()
@RestController
@RequestMapping({ "/EmployeeExamples" })
public class TestController {

	private List<EmployeeExample> EmployeeExamples = createList();

	@GetMapping(produces = "application/json")
	public List<EmployeeExample> firstPage() {
		return EmployeeExamples;
	}

	@DeleteMapping(path = { "/{id}" })
	public EmployeeExample delete(@PathVariable("id") int id) {
		EmployeeExample deletedEmp = null;
		for (EmployeeExample emp : EmployeeExamples) {
			if (emp.getEmpId().equals(id)) {
				EmployeeExamples.remove(emp);
				deletedEmp = emp;
				break;
			}
		}
		return deletedEmp;
	}

	@PostMapping
	public EmployeeExample create(@RequestBody EmployeeExample user) {
		EmployeeExamples.add(user);
		return user;
	}

	private static List<EmployeeExample> createList() {
		List<EmployeeExample> tempEmployeeExamples = new ArrayList<>();
		EmployeeExample emp1 = new EmployeeExample();
		emp1.setName("emp1");
		emp1.setDesignation("manager");
		emp1.setEmpId("1");
		emp1.setSalary(3000);

		EmployeeExample emp2 = new EmployeeExample();
		emp2.setName("emp2");
		emp2.setDesignation("developer");
		emp2.setEmpId("2");
		emp2.setSalary(3000);
		tempEmployeeExamples.add(emp1);
		tempEmployeeExamples.add(emp2);
		
		
		return tempEmployeeExamples;
		
	}

}