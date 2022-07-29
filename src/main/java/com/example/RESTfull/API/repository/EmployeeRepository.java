package com.example.RESTfull.API.repository;

import com.example.RESTfull.API.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findEmployeeByFullName(String fullName);

    List<Employee> findAllByLastName(String lastName);

    Employee getEmployeeById(Integer id);


}
