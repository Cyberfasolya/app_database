package database.app_database.Converter;

import database.app_database.Dao.Roles;
import database.app_database.Dto.EmployeeDto;
import database.app_database.Model.Employee.Employee;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EmployeeConverter {
    public List<EmployeeDto> convertAllEmployees(Map<Roles, List<Employee>> rolesMap) {
        return rolesMap.entrySet()
                .stream()
                .map(entry -> entry.getValue()
                        .stream()
                        .map(employee -> convertEmployee(employee,entry.getKey()))
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public EmployeeDto convertEmployee(Employee employee, Roles role)
    {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setGender(employee.getGender());
        dto.setMonthlySalary(employee.getMonthlySalary());
        dto.setName(employee.getName());
        dto.setSurname(employee.getSurname());
        dto.setWorkStartDate(dto.getWorkStartDate());
        dto.setRole(role.toString());

        return dto;
    }
}
