package com.tistory.eclipse4j.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tistory.eclipse4j.entity.employee.Employee;
import com.tistory.eclipse4j.service.employee.EmployeeFindCachedService;
import com.tistory.eclipse4j.service.employee.EmployeeFindService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeFindService employeeFindService;
    @Autowired
    private EmployeeFindCachedService employeeFindCachedService;

    @GetMapping(value = "/employees/{id}", produces = "application/json")
    public Employee getEmployee(@PathVariable("id") Long id) {
        Employee employee = employeeFindService.findById(id);
        return employee;
    }

    @GetMapping(value = "/employees/cached/{id}", produces = "application/json")
    public Employee getCachedEmployee(@PathVariable("id") Long id) {
        return employeeFindCachedService.findById(id);
    }

    @GetMapping(value = "/employees/cached/{id}/invalidate", produces = "application/json")
    public int invalidateCachedEmployee(@PathVariable("id") Long id) {
        try {
         employeeFindCachedService.invalidateCacheById(id);
         return HttpStatus.OK.value();
        }catch (Exception e) {
            log.error("캐시 초기화 오류입니다.", e);
        }
        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
}
