package com.symplifica.employee_api.repository;

import com.symplifica.employee_api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
