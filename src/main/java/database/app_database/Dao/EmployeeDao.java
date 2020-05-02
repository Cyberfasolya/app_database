package database.app_database.Dao;
import database.app_database.Model.Employee.Employee;
import database.app_database.Model.Employee.QEmployee;
import org.springframework.stereotype.Repository;
import static database.app_database.Model.Employee.QEmployee.employee;
import static database.app_database.Model.Employee.AccessWorker.QVet.vet;
import static database.app_database.Model.Employee.AccessWorker.QCleaner.cleaner;


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

   public List<Employee> getAllVet(){
       return from(vet)
//                .join(accessWorker).on(accessWorker.id.eq(vet.access_worker.id))
//               .join(employee).on(accessWorker.employee.id.eq())
               .select(vet.accessWorker.employee)
               .fetch();
   }
    public List<Employee> getAllCleaner(){
        return from(cleaner)
                .select(cleaner.accessWorker.employee)
                .fetch();
    }



}


