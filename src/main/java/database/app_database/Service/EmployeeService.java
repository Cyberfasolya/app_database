package database.app_database.Service;

import database.app_database.Converter.EmployeeConverter;
import database.app_database.Dao.EmployeeDao;
import database.app_database.Dao.Roles;
import database.app_database.Dto.EmployeeDto;
import database.app_database.Model.Employee.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Transactional
    public List<EmployeeDto> getAll(String role, String gender, Integer lowSalary, Integer highSalary, Integer durationOfWorkLow, Integer durationOfWorkHigh) {

        logger.info(role);
        Instant highDate = durationOfWorkLow == null ? null : ZonedDateTime.now().minusYears(durationOfWorkLow).toInstant();
        Instant lowDate = durationOfWorkHigh == null ? null : ZonedDateTime.now().minusYears(durationOfWorkHigh).toInstant();
        List<Employee> employees = employeeDao.getAll(role, gender, lowSalary, highSalary, lowDate, highDate);

        logger.info(String.valueOf(employees.size()));
        List<EmployeeDto> result = employees
                .stream()
                .filter(employee -> role == null || Roles.valueOf(role).equals(employee.getRole()))
                .map(employeeConverter::convertEmployee)
                .collect(Collectors.toList());

        logger.info(String.valueOf(result.size()));
        return result;
    }
}

