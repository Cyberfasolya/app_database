package database.app_database.Service;

import database.app_database.Converter.Converter;
import database.app_database.Dao.EmployeeDao;
import database.app_database.Dao.Roles;
import database.app_database.Dto.EmployeeDto;
import database.app_database.Model.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    Converter converter;

    @Transactional
    public List<EmployeeDto> getAll() {
        var rolesMap = new HashMap<Roles, List<Employee>>();
       // rolesMap.put(Roles.vet, employeeDao.getAllVet());
        return converter.convertAllEmployees(rolesMap);
    }
}

