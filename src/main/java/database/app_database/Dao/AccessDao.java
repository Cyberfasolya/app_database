package database.app_database.Dao;

import com.querydsl.core.BooleanBuilder;
import database.app_database.Model.Employee.AccessWorker.Access;
import database.app_database.Model.Employee.AccessWorker.QAccess;
import org.springframework.stereotype.Repository;
import static database.app_database.Model.Employee.AccessWorker.QAccess.access;

import java.time.Instant;
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

    public List<Access> getAccessByInfo(String animalName, String species, Instant highDate, Instant lowDate) {
        var predicate = new BooleanBuilder();
        if (species != null) {
            predicate.and(access.animal.species.name.eq(species));
        }

        if (animalName != null) {
            predicate.and(access.animal.name.eq(animalName));
        }

        if (highDate != null) {
            predicate.and(access.accessStartDate.before(highDate));
        }

        if (lowDate != null) {
            predicate.and(access.accessStartDate.after(lowDate));
        }

        return from(access)
                .where(predicate.getValue())
                .select(access)
                .fetch();
    }
}
