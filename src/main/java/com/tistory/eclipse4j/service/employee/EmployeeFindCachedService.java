package com.tistory.eclipse4j.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.code.ssm.api.InvalidateSingleCache;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.tistory.eclipse4j.entity.employee.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeFindCachedService {

    @Autowired
    private EmployeeFindService employeeFindService;

    @ReadThroughSingleCache(namespace = "EmployeeFindService:findCachedById_v01", expiration = 600)
    public Employee findById(@ParameterValueKeyProvider Long id) {
        return employeeFindService.findById(id);
    }
    
    @InvalidateSingleCache(namespace = "EmployeeFindService:findCachedById_v01")
    public void invalidateCacheById(@ParameterValueKeyProvider Long id) {
        log.debug("InvalidateSingCache Employee By Id = {}", id);
    }
}
