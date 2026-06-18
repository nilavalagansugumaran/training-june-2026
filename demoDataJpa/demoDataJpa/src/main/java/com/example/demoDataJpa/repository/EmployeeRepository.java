package com.example.demoDataJpa.repository;

import com.example.demoDataJpa.model.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@EnableTransactionManagement
public class EmployeeRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Employee getEmployeeFromDB(Integer id){
        Employee emp = entityManager.find(Employee.class, id);
        return emp;
    }

    public Employee getEmployeeByName(String name){

        String jql = "select e from Employee e where e.name=:name";
        TypedQuery<Employee> query = entityManager.createQuery(jql, Employee.class)
                .setParameter("name", name);
        return  query.getSingleResultOrNull();
    }

    @Transactional
    public void updateEmpInDb(Integer id, Employee employee) {

        Employee empFromDB = entityManager.find(Employee.class, id);
        empFromDB.setSalary(employee.getSalary());

    }

    @Transactional
    public void deleteEmpInDb(Integer id) {
        Employee empFromDB = entityManager.find(Employee.class, id);
        entityManager.remove(empFromDB);
    }

    @Transactional
    public Employee createEmpInDb(Employee employee) {
        entityManager.persist(employee);
        entityManager.flush();
        return employee;
    }

    public List<Employee> getAllEmpFromDb() {

        String jql = "select e from Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(jql, Employee.class);
        return  query.getResultList();
    }


}
