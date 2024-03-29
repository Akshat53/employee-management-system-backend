package com.employee.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByRole(String role);
	List<Employee> findByDepartment(String department);
}