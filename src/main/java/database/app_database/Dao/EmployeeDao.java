package database.app_database.Dao;
import database.app_database.Model.Employee.Employee;
import database.app_database.Model.Employee.QEmployee;
import org.springframework.stereotype.Repository;
import static database.app_database.Model.Employee.QEmployee.employee;
import java.util.List;

@Repository
public class EmployeeDao extends BaseEntityDao<Employee, QEmployee> {
    public EmployeeDao() {
        super(employee);
    }

    public List<Employee> getAll() {
        return from(employee)
                .select(employee)
                .fetch();
    }
}


