package com.avantika.employeeservice.service;

import com.avantika.employeeservice.model.Employee;
import com.avantika.employeeservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee>getAllEmployeeByID(Long id){
        return (List<Employee>) employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);

    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()->
                new RuntimeException("Employee not found with id"+id));
    }
}
