package com.example.RESTfull.API.Controller;

import com.example.RESTfull.API.Model.Employee;
import com.example.RESTfull.API.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    private final Map<Integer, Employee> employees = new HashMap<>();

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees(final @RequestParam(value = "lastName", required = false) String lastName){
        if(lastName == null) {
            return employeeService.getEmployees();
        }

        return employeeService.getAllByLastName(lastName);
    }

    @GetMapping("/{id}")
    public Employee getEmployee (final @PathVariable("id")Integer employeeId) {
        return employees.get(employeeId);
    }

    @PostMapping
    public Employee registerNewEmployee (final @RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee (@PathVariable("id")Integer employeeId){
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee (final @PathVariable("id") Integer employeeId,
                                    final @RequestParam(required = false) String lastName,
                                    final @RequestParam(required = false) String fullName){
        return employeeService.updateEmployee(employeeId, lastName, fullName);
    }
}
