package com.example.demoDataJdbc.repository;

import com.example.demoDataJdbc.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public Employee getEmployeeByName(String name){

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

        String sql = "select * from employees";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
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

    public static class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Employee.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .salary(rs.getDouble("salary"))
                    .build();
        }
    }

}
