package com.example.demoDataJdbc.repository;

import com.example.demoDataJdbc.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Employee getEmployeeFromDB(Integer id){

        return  null;
    }
    public void updateEmpInDb(Integer id, Employee employee) {

    }
    public void deleteEmpInDb(Integer id) {

    }

    public Employee createEmpInDb(Employee employee) {

        return  null;
    }

    public List<Employee> getAllEmpFromDb() {
        return null;
    }

    @PostConstruct
    public void seedDB() {
        jdbcTemplate.execute("create table EMPLOYEES(" +
                "id int auto_increment, " +
                "name varchar(50), " +
                "salary double, " +
                "primary key (id) )");
        jdbcTemplate.update("insert into EMPLOYEES (name, salary) " +
                        "values (?, ?)",
                new Object[]{"James", 21000});
    }


}
