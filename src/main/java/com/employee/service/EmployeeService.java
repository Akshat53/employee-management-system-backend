package com.employee.service;


import java.util.List;
import java.util.Optional;

import com.employee.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    boolean deleteEmployee(Long id);
    List<Employee> getEmployeeByRole(String role);
    List<Employee> getEmployeeByDepartment(String department);
}