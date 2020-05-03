package database.app_database.Service;

import database.app_database.Converter.EmployeeConverter;
import database.app_database.Dao.EmployeeDao;
import database.app_database.Dao.Roles;
import database.app_database.Dto.EmployeeDto;
import database.app_database.Model.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    EmployeeConverter employeeConverter;

    @Transactional
    public List<EmployeeDto> getAll() {
        var rolesMap = new HashMap<Roles, List<Employee>>();
        rolesMap.put(Roles.vet, employeeDao.getAllVet());
        rolesMap.put(Roles.cleaner, employeeDao.getAllCleaner());
        rolesMap.put(Roles.trainer, employeeDao.getAllTrainer());
        rolesMap.put(Roles.administrator, employeeDao.getAllAdministrator());
        rolesMap.put(Roles.builderWorker, employeeDao.getAllBuilderWorker());

        return employeeConverter.convertAllEmployees(rolesMap);
    }
}

