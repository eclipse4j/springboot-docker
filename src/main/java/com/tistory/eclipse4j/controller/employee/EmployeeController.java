package com.tistory.eclipse4j.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tistory.eclipse4j.entity.employee.Employee;
import com.tistory.eclipse4j.service.employee.EmployeeFindService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeFindService employeeFindService;

	@GetMapping("/employees/{id}")
	public Employee getHello(@PathVariable("id") Long id) {
		return employeeFindService.findById(id);
	}
}
