package com.tistory.eclipse4j.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
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

    @ReadThroughSingleCache(namespace = "EmployeeFindService:findCachedById_v01", expiration = 600)
    public Employee findCachedById(@ParameterValueKeyProvider Long id) {
        return employeeRepository.findOne(id);
    }
}
