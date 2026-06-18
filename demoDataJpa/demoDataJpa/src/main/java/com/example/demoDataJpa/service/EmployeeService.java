package com.example.demoDataJpa.service;

import com.example.demoDataJpa.model.Employee;
import com.example.demoDataJpa.repository.EmployeeJpaRepository;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Service
@EnableTransactionManagement
public class EmployeeService {

    private EmployeeJpaRepository employeeJpaRepository;

    @Autowired
    public EmployeeService(EmployeeJpaRepository employeeJpaRepository) {
        this.employeeJpaRepository = employeeJpaRepository;
    }


    public Employee getEmployeeFromDB(Integer id){

    }

    public Employee getEmployeeByName(String name){


    }

    @Transactional
    public void updateEmpInDb(Integer id, Employee employee) {


    }

    @Transactional
    public void deleteEmpInDb(Integer id) {

    }

    @Transactional
    public Employee createEmpInDb(Employee employee) {

    }

    public List<Employee> getAllEmpFromDb() {


    }

}
