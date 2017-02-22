package com.tistory.eclipse4j.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.eclipse4j.entity.employee.Employee;
import com.tistory.eclipse4j.entity.employee.EmployeeRepository;

@Service
@Transactional(readOnly = true)
public class EmployeeFindService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee findById(Long id) {
		return employeeRepository.findOne(id);
	}
}
