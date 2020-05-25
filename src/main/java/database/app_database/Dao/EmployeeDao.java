package database.app_database.Dao;

import database.app_database.Model.Employee.BuilderWorker;
import database.app_database.Model.Employee.Employee;
import database.app_database.Model.Employee.QEmployee;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Employee.QEmployee.employee;
import static database.app_database.Model.Employee.AccessWorker.QVet.vet;
import static database.app_database.Model.Employee.AccessWorker.QCleaner.cleaner;
import static database.app_database.Model.Employee.AccessWorker.QTrainer.trainer;
import static database.app_database.Model.Employee.QAdministrator.administrator;
import static database.app_database.Model.Employee.QBuilderWorker.builderWorker;

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

    public List<Employee> getAllVet() {
        return from(vet)
                .select(vet.accessWorker.employee)
                .fetch();
    }

    public List<Employee> getAllCleaner() {
        return from(cleaner)
                .select(cleaner.accessWorker.employee)
                .fetch();
    }

    public List<Employee> getAllTrainer() {
        return from(trainer)
                .select(trainer.accessWorker.employee)
                .fetch();
    }

    public List<Employee> getAllAdministrator() {
        return from(administrator)
                .select(administrator.employee)
                .fetch();
    }

    public List<BuilderWorker> getAllBuilderWorker() {
        return from(builderWorker)
                .select(builderWorker)
                .fetch();
    }

}


