package com.employee.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.employee.exception.DepartmentNotFoundException;
import com.employee.exception.RoleNotFoundException;
import com.employee.model.Employee;
import com.employee.response.ApiResponse;
import com.employee.service.EmployeeService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(new ApiResponse<>(true, "Employees fetched successfully", employees));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> optionalEmployee = employeeService.getEmployeeById(id);
        if (optionalEmployee.isPresent()) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Employee found", optionalEmployee.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Employee not found", null));
    }
    
    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> createEmployee(@Validated @RequestBody Employee employee) {
        
        Employee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Employee created", createdEmployee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable Long id, @Validated @RequestBody Employee employee) {
        
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Employee updated", updatedEmployee));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Employee not found", null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteEmployee(@PathVariable Long id) {
        if (employeeService.deleteEmployee(id)) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Employee deleted", null));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Employee not found", null));
    }
    @GetMapping("/role/{role}")
    public ResponseEntity<ApiResponse<List<Employee>>> getEmployeeByRole(@PathVariable String role) {
        try {
            List<Employee> employees = employeeService.getEmployeeByRole(role);
            return ResponseEntity.ok(new ApiResponse<>(true, "Employees fetched successfully", employees));
        } catch (RoleNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(new ApiResponse<>(false, e.getMessage(), null));
        }
        
    }
 
    
    @GetMapping("/department/{department}")
    public ResponseEntity<ApiResponse<List<Employee>>> getEmployeeByDepartment(@PathVariable String department) {
        try {
            List<Employee> employees = employeeService.getEmployeeByDepartment(department);
            return ResponseEntity.ok(new ApiResponse<>(true, "Employees fetched successfully", employees));
        } catch (DepartmentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(new ApiResponse<>(false, e.getMessage(), null));
        }
}
}
