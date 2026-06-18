package com.example.demoDataJdbc.controller;

import com.example.demoDataJdbc.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/employee", produces = {"application/json"})
public class EmployeeController {

    @RequestMapping(method = RequestMethod.GET)
    public Employee getEmployee(@RequestParam Integer id) {

        return  null;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public List<Employee> getAllEmployee() {

        return  null;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {

        return  null;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {

    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployee(@PathVariable Integer id) {

    }

}
