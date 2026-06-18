package com.example.demoDataJdbc.controller;

import com.example.demoDataJdbc.model.Employee;
import com.example.demoDataJdbc.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/employee", produces = {"application/json"})
public class EmployeeController {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Employee getEmployee(@RequestParam Integer id) {

        return  repository.getEmployeeFromDB(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public List<Employee> getAllEmployee() {

        return  repository.getAllEmpFromDb();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {

        return  repository.createEmpInDb(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        repository.updateEmpInDb(id, employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Integer id) {
        repository.deleteEmpInDb(id);
    }

}
