package database.app_database.Dao;


import database.app_database.Model.Exchange.QZoo;
import database.app_database.Model.Exchange.Zoo;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Exchange.QZoo.zoo;

import java.util.List;

@Repository
public class ZooDao extends BaseEntityDao<Zoo, QZoo> {

    public ZooDao() {
        super(zoo);
    }

    public List<Zoo> getAll() {
        return from(zoo)
                .select(zoo)
                .fetch();
    }
    public Zoo get(int id){
        return from(zoo)
                .where(zoo.id.eq(id))
                .select(zoo)
                .fetchFirst();
    }
}
