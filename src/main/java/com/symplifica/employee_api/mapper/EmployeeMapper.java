package com.symplifica.employee_api.mapper;

import com.symplifica.employee_api.dto.employee.EmployeeResponseDto;
import com.symplifica.employee_api.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "employeeId", target = "id")
    @Mapping(source = "employeeFirstName", target = "firstName")
    @Mapping(source = "employeeSecondName", target = "secondName")
    @Mapping(source = "employeeFirstLastName", target = "firstLastName")
    @Mapping(source = "employeeSecondLastName", target = "secondLastName")
    @Mapping(source = "creationDate", target = "date")

    EmployeeResponseDto toDto(Employee employee);
}
