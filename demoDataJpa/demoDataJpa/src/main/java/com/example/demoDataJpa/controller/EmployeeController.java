package com.example.demoDataJpa.controller;

import com.example.demoDataJpa.model.Employee;
import com.example.demoDataJpa.repository.EmployeeRepository;
import com.example.demoDataJpa.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/employee", produces = {"application/json"})
public class EmployeeController {

    @Value("${enabled.service}")
    private String jpaEnabled;

    private EmployeeRepository repository;

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeRepository repository, EmployeeService service) {
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Employee getEmployee(@RequestParam Integer id) {
        if(jpaEnabled.equals("jpa")) {
            return service.getEmployeeFromDB(id);
        }
        return  repository.getEmployeeFromDB(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public List<Employee> getAllEmployee() {
        if(jpaEnabled.equals("jpa")) {
            return service.getAllEmpFromDb();
        }
        return  repository.getAllEmpFromDb();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {
        if(jpaEnabled.equals("jpa")) {
            return service.createEmpInDb(employee);
        }
        return  repository.createEmpInDb(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {

        if(jpaEnabled.equals("jpa")) {
            service.updateEmpInDb(id, employee);
        }
        repository.updateEmpInDb(id, employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Integer id) {
        if(jpaEnabled.equals("jpa")) {
            service.deleteEmpInDb(id);
        }
        repository.deleteEmpInDb(id);
    }

}
