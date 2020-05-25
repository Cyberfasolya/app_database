package database.app_database.Dao;

import database.app_database.Model.Employee.AccessWorker.Access;
import database.app_database.Model.Employee.AccessWorker.QAccess;
import org.springframework.stereotype.Repository;

@Repository
public class AccessDao extends BaseEntityDao<Access, QAccess> {
    public AccessDao() {
        super(QAccess.access);
    }
}
