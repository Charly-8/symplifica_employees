package com.symplifica.employee_api.service;

import com.symplifica.employee_api.dto.employee.EmployeeRequestDto;
import com.symplifica.employee_api.dto.employee.EmployeeResponseDto;
import com.symplifica.employee_api.mapper.EmployeeMapper;
import com.symplifica.employee_api.model.Employee;
import com.symplifica.employee_api.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRespository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepo, EmployeeMapper mapper) {
        this.employeeRespository = employeeRepo;
        this.employeeMapper = mapper;
    }

    // Get all employees
    public List<EmployeeResponseDto> getEmployees() {
        List<Employee> employees = employeeRespository.findAll();

        return employees.stream()
                .map(this::mapToResponseDto) // "en cada punto de la cinta, aplica este método mío a la caja que pasa"
                .collect(Collectors.toList());
    }

    // Get employee by id
    public EmployeeResponseDto getEmployeeById(Long id) {
        Employee employeeSelected = employeeRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return mapToResponseDto(employeeSelected);
    }

    // Create employee
    public EmployeeResponseDto addEmployee(EmployeeRequestDto employeeToCreate) {
        Employee employeeToEntity = mapToEntity(employeeToCreate);

        return mapToResponseDto(employeeRespository.save(employeeToEntity));
    }

    // Update employee
    public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto employeeToUpdate) {

        Employee employeeSelected = employeeRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));


        employeeSelected.setEmployeeFirstName(employeeToUpdate.getFirstName());
        employeeSelected.setEmployeeSecondName(employeeToUpdate.getSecondName());
        employeeSelected.setEmployeeFirstLastName(employeeToUpdate.getFirstLastName());
        employeeSelected.setEmployeeSecondLastName(employeeToUpdate.getSecondLastName());
        employeeSelected.setEmail(employeeToUpdate.getEmail());
        employeeSelected.setCity(employeeToUpdate.getCity());

        employeeRespository.save(employeeSelected);

        return mapToResponseDto(employeeSelected);
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        employeeRespository.deleteById(id);
    }


    // DTOs
    private EmployeeResponseDto mapToResponseDto(Employee employeeToDto) {
        return employeeMapper.toDto(employeeToDto);
    }

    private Employee mapToEntity(EmployeeRequestDto dto) {
        Employee employee = new Employee();

        employee.setEmployeeFirstName(dto.getFirstName());
        employee.setEmployeeSecondName(dto.getSecondName());
        employee.setEmployeeFirstLastName(dto.getFirstLastName());
        employee.setEmployeeSecondLastName(dto.getSecondLastName());
        employee.setEmail(dto.getEmail());
        employee.setCity(dto.getCity());

        return employee;
    }
}