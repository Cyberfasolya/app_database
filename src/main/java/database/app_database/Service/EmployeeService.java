package database.app_database.Service;

import database.app_database.Converter.EmployeeConverter;
import database.app_database.Dao.EmployeeDao;
import database.app_database.Dto.EmployeeDto;
import database.app_database.Model.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Transactional
    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeDao.getAll();
        return employees
                .stream()
                .map(employeeConverter::convertEmployee)
                .collect(Collectors.toList());
    }
}

