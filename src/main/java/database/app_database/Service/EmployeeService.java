package database.app_database.Service;

import database.app_database.Converter.EmployeeConverter;
import database.app_database.Dao.AccessDao;
import database.app_database.Dao.EmployeeDao;
import database.app_database.Dao.Roles;
import database.app_database.Dto.EmployeeDto;
import database.app_database.Model.Employee.AccessWorker.Access;
import database.app_database.Model.Employee.BuilderWorker;
import database.app_database.Model.Employee.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private AccessDao accessDao;

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

    @Transactional
    public void create(EmployeeDto employeeDto) {
        LocalDate workStartDate = LocalDate.parse(employeeDto.getWorkStartDate());

        if (employeeDto.getRole().equals("builderWorker")) {
            BuilderWorker builderWorker = new BuilderWorker();

            builderWorker.setName(employeeDto.getName());
            builderWorker.setSurname(employeeDto.getSurname());
            builderWorker.setGender(employeeDto.getGender());
            builderWorker.setMonthlySalary(employeeDto.getMonthlySalary());
            builderWorker.setWorkStartDate(workStartDate.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant());
            builderWorker.setBuildingForRepair(employeeDto.getRoleAttribute());

            employeeDao.persist((Employee)builderWorker);//?? p_key error
        }

    }

    @Transactional
    public List<EmployeeDto> getAccessEmployeesByInfo(String animalName, String species, Integer lowAmount, Integer highAmount){
        Instant highDate = lowAmount == null ? null : ZonedDateTime.now().minusYears(lowAmount).toInstant();
        Instant lowDate = highAmount == null ? null : ZonedDateTime.now().minusYears(highAmount).toInstant();
        List<Access> accesses = accessDao.getAccessByInfo(animalName, species, highDate, lowDate);
        return accesses
                .stream()
                .map(employeeConverter::convertAccessEmployee)
                .collect(Collectors.toList());
    }
}

