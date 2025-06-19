package com.demo.employee_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Optional<EmployeeEntity> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Add a new employee
    public EmployeeEntity addEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    // Update an existing employee
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }

    // Delete an employee
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
