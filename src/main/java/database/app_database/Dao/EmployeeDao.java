package database.app_database.Dao;

import com.querydsl.core.BooleanBuilder;
import database.app_database.Model.Employee.BuilderWorker;
import database.app_database.Model.Employee.Employee;
import database.app_database.Model.Employee.QEmployee;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Employee.QEmployee.employee;
import static database.app_database.Model.Employee.QBuilderWorker.builderWorker;

import java.time.Instant;
import java.util.List;

@Repository
public class EmployeeDao extends BaseEntityDao<Employee, QEmployee> {
    public EmployeeDao() {
        super(employee);
    }

    public List<Employee> getAll(String role, String gender, Integer lowSalary, Integer highSalary, Instant lowDate, Instant highDate) {
        var predicate = new BooleanBuilder();

        if (gender != null) {
            predicate.and(employee.gender.eq(gender));
        }

        if (lowDate != null) {
            predicate.and(employee.workStartDate.after(lowDate));
        }

        if (highDate != null) {
            predicate.and(employee.workStartDate.before(highDate));
        }

        if (lowSalary != null) {
            predicate.and(employee.monthlySalary.goe(lowSalary));
        }

        if (highSalary != null) {
            predicate.and(employee.monthlySalary.loe(highSalary));
        }

        return from(employee)
                .where(predicate.getValue())
                .select(employee)
                .fetch();
    }

}


