package database.app_database.Dao;

import database.app_database.Model.Employee.AccessWorker.QVet;
import database.app_database.Model.Employee.AccessWorker.Vet;
import database.app_database.Model.Employee.Employee;
import org.springframework.stereotype.Repository;

import javax.inject.Qualifier;
import java.util.List;

@Repository
public class VetDao extends BaseEntityDao<Vet, QVet> {
    public VetDao() {
        super(QVet.vet);
    }
}
