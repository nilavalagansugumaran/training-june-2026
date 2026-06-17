package com.example.demoRestService.controller;

import com.example.demoRestService.model.Employee;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee", produces = {"application/json"})
public class EmployeeController {

    @RequestMapping(method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(23456);
        return employee;
    }
}
