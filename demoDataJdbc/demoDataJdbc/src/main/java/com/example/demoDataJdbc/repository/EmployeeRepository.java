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

        String sql = "select * from employees where id=?";
        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
    }

    public Employee getEmployeeByName(String name){

        String sql = "select * from employees where name=?";
        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), name);
    }

    public void updateEmpInDb(Integer id, Employee employee) {

        String sql = "update employees set salary = ? where id = ?";
        jdbcTemplate.update(sql,employee.getSalary(), id);

    }
    public void deleteEmpInDb(Integer id) {
        String sql = "delete from employees where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Employee createEmpInDb(Employee employee) {

        jdbcTemplate.update("insert into EMPLOYEES (name, salary) " +
                        "values (?, ?)",
                new Object[]{employee.getName(), employee.getSalary()});
        return getEmployeeByName(employee.getName());
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
