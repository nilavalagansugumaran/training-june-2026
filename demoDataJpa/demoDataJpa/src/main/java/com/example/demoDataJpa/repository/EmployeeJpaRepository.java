package com.example.demoDataJpa.repository;

import com.example.demoDataJpa.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeJpaRepository extends CrudRepository<Employee, Integer> {

    Optional<Employee> findByIdAndName(Integer id, String name);

    Optional<Employee> findByName(String name);
}
