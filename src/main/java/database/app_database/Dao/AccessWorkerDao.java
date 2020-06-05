package database.app_database.Dao;


import database.app_database.Model.Employee.AccessWorker.AccessWorker;
import database.app_database.Model.Employee.AccessWorker.QAccessWorker;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Employee.AccessWorker.QAccessWorker.accessWorker;

import java.util.List;

@Repository
public class AccessWorkerDao extends BaseEntityDao<AccessWorker, QAccessWorker> {

    public AccessWorkerDao() {
        super(accessWorker);
    }

    public AccessWorker getByNameAndSurname(String name, String surname){
        return from(accessWorker)
                .where(accessWorker.name.eq(name).and(accessWorker.surname.eq(surname)))
                .select(accessWorker)
                .fetchFirst();
    }

}