package com.example.demoRestService.controller;

import com.example.demoRestService.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/employee", produces = {"application/json", "application/xml"})
@Slf4j
public class EmployeeController {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(23456);
        return employee;
    }
    @RequestMapping(method = RequestMethod.PUT, path="/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateEmployee(@PathVariable Integer id, @RequestBody Employee emp) {
        log.info("Employee updated");
    }
    @RequestMapping(method = RequestMethod.DELETE, path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Integer id) {
        log.info("Employee deleted");
    }
    @RequestMapping(method = RequestMethod.GET)
    public Employee getEmployee(@RequestParam("id") Integer id) {
        return Employee.builder()
                .id(123)
                .name("Nila")
                .email("nila@nila.com")
                .salary(20000.00)
                .build();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public List<Employee> getAllEmployee(ModelMap modelMap) {
        return (List<Employee>)modelMap.get("employees");
    }

    @ModelAttribute("employees")
    public List<Employee> employees(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(Employee.builder()
                .id(123)
                .name("Nila1")
                .email("nila@nila.com")
                .salary(20000.00)
                .build());
        employeeList.add(Employee.builder()
                .id(234)
                .name("Nila 2")
                .email("nila@nila.com")
                .salary(10000.00)
                .build());
        employeeList.add(Employee.builder()
                .id(456)
                .name("Nila 3")
                .email("nila@nila.com")
                .salary(22000.00)
                .build());

        return employeeList;
    }
}
