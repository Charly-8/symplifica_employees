package com.symplifica.employee_api.controller;


import com.symplifica.employee_api.dto.employee.EmployeeRequestDto;
import com.symplifica.employee_api.dto.employee.EmployeeResponseDto;
import com.symplifica.employee_api.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeService.getEmployees();
    }

    // Create employee
    @PostMapping
    public EmployeeResponseDto addNewEmployee(@RequestBody EmployeeRequestDto newEmployee) {
        return employeeService.addEmployee(newEmployee);
    }

    //Get employee by id
    @GetMapping("/{id}")
    public EmployeeResponseDto getEmployeeId(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    // Update
    @PostMapping("/{id}")
    public EmployeeResponseDto updateEmployee(@PathVariable long id, @RequestBody EmployeeRequestDto employeeToUpdate) {
        return employeeService.updateEmployee(id, employeeToUpdate);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleleteEmployeeById(@PathVariable long id) {
        employeeService.deleteEmployee(id);
    }

}
