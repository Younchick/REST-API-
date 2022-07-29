package com.example.RESTfull.API.Services;

import com.example.RESTfull.API.Model.Employee;
import com.example.RESTfull.API.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> getAllByLastName(String lastName){
        return employeeRepository.findAllByLastName(lastName);
    }

    public Employee addEmployee(Employee employee){
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByFullName(employee.getFullName());
                if(employeeOptional.isPresent()) {
                    throw new IllegalStateException("FullName taken");
                }

                employeeRepository.save(employee);
                return employee;
    }

    public void deleteEmployee (Integer employeeId){
        boolean exist = employeeRepository.existsById(employeeId);
        if(!exist) {
            throw new IllegalStateException("Employee with id " + employeeId + "does not exists.");
        }
        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public Employee updateEmployee(Integer employeeId, String lastName, String fullName) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException(
                        "Employee with this ID " + employeeId + "does not exists. "
                ));

        if(lastName != null && lastName.length() > 0 && !Objects.equals(employee.getFirstName(), lastName)){
            employee.setFirstName(lastName);
        }

        if(fullName != null && fullName.length() > 0 && !Objects.equals(employee.getFullName(), fullName)){
            Optional<Employee> employeeOptional = employeeRepository.findEmployeeByFullName(fullName);
            if(employeeOptional.isPresent()){
                throw new IllegalStateException("Email is taken. Try to use another one");
            }
            employee.setFullName(fullName);
        }
        return employeeRepository.getEmployeeById(employeeId);
    }
}
