package database.app_database.Dao;

import database.app_database.Model.Employee.AccessWorker.Access;
import database.app_database.Model.Employee.AccessWorker.QAccess;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccessDao extends BaseEntityDao<Access, QAccess> {
    public AccessDao() {
        super(QAccess.access);
    }

    public List<Access> getAll() {
        return from(QAccess.access)
                .select(QAccess.access)
                .fetch();
    }
}
