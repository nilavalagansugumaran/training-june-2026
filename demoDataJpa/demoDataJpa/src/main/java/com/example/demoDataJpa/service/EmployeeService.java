package com.example.demoDataJpa.service;

import com.example.demoDataJpa.model.Employee;
import com.example.demoDataJpa.repository.EmployeeJpaRepository;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@EnableTransactionManagement
public class EmployeeService {

    private EmployeeJpaRepository employeeJpaRepository;

    @Autowired
    public EmployeeService(EmployeeJpaRepository employeeJpaRepository) {
        this.employeeJpaRepository = employeeJpaRepository;
    }


    public Employee getEmployeeFromDB(Integer id){
        Optional<Employee> oe =  employeeJpaRepository.findById(id);
        if(oe.isPresent()) {
            return  oe.get();
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Employee not found");
    }

    public Employee getEmployeeByName(String name){
        Optional<Employee> oe =  employeeJpaRepository.findByName(name);
        if(oe.isPresent()) {
            return  oe.get();
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Employee not found");

    }

    @Transactional
    public void updateEmpInDb(Integer id, Employee employee) {
        Employee orig = getEmployeeFromDB(id);
        orig.setSalary(employee.getSalary());
        employeeJpaRepository.save(orig);
    }

    @Transactional
    public void deleteEmpInDb(Integer id) {
        employeeJpaRepository.deleteById(id);
    }

    @Transactional
    public Employee createEmpInDb(Employee employee) {
        return employeeJpaRepository.save(employee);
    }

    public List<Employee> getAllEmpFromDb() {

        Iterator<Employee> employeeIterator = employeeJpaRepository.findAll().iterator();
        List<Employee> employeeList = new ArrayList<>();
        while (employeeIterator.hasNext()) {
            employeeList.add(employeeIterator.next());
        }
        return employeeList;
    }

}
