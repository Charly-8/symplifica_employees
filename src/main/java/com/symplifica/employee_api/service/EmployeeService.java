package com.symplifica.employee_api.service;

import com.symplifica.employee_api.model.Employee;
import com.symplifica.employee_api.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRespository;

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRespository = employeeRepo;
    }

    public List<Employee> getAllEmployees() {
        return employeeRespository.findAll();
    }

    // Find by id
    public Employee getEmployeeById(Long id) {
        return employeeRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // Create Employee
    public Employee createEmployee(Employee employee) {
        return employeeRespository.save(employee);
    }

    // Update Employee
    public Employee updateEmployee(Long id, Employee employeeToUpdate) {
        Employee employee = getEmployeeById(id);

        employee.setNombreBeneficio(employeeToUpdate.getNombreBeneficio());
        employee.setMonto(employeeToUpdate.getMonto());

        return employeeRespository.save(employee);
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        employeeRespository.deleteById(id);
    }
}
