package database.app_database.Dao;


import com.querydsl.core.BooleanBuilder;
import database.app_database.Model.Exchange.QZoo;
import database.app_database.Model.Exchange.Zoo;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Exchange.QZoo.zoo;
import static database.app_database.Model.Exchange.QExchange.exchange;

import java.util.List;

@Repository
public class ZooDao extends BaseEntityDao<Zoo, QZoo> {

    public ZooDao() {
        super(zoo);
    }

    public List<Zoo> getAll(Integer speciesId) {

        var predicate = new BooleanBuilder();
        if (speciesId != null) {
            predicate.and(exchange.animal.species.id.eq(speciesId));
        }

        return from(exchange)
                .join(zoo).on(zoo.eq(exchange.zoo))
                .where(predicate.getValue())
                .select(zoo)
                .distinct()
                .fetch();
    }

    public Zoo get(int id) {
        return from(zoo)
                .where(zoo.id.eq(id))
                .select(zoo)
                .fetchFirst();
    }
}
