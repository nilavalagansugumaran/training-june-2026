package com.example.demoDataJpa.repository;

import com.example.demoDataJpa.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJpaRepository extends CrudRepository<Employee, Integer> {
}
