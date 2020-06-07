package database.app_database.Dao;

import com.querydsl.core.BooleanBuilder;
import database.app_database.Model.Feed.QSupply;
import database.app_database.Model.Feed.Supply;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Feed.QSupply.supply;

import java.time.Instant;
import java.util.List;

@Repository
public class SupplyDao extends BaseEntityDao<Supply, QSupply> {

    public SupplyDao() {
        super(supply);
    }

    public List<Supply> getAll() {
        return from(supply)
                .select(supply)
                .fetch();
    }

    public List<Supply> getZooSupplies() {
        return from(supply)
                .where(supply.provider.name.eq("Зоопарк"))
                .select(supply)
                .fetch();
    }

    public List<Supply> getByBasicInfo(String feedName, Integer lowAmount, Integer highAmount,
                                       Instant highDate, Instant lowDate, Integer lowPrice, Integer highPrice) {
        var predicate = new BooleanBuilder();
        if (feedName != null) {
            predicate.and(supply.feed.name.eq(feedName));
        }

        if (lowAmount != null) {
            predicate.and(supply.feedAmount.goe(lowAmount));
        }

        if (highAmount != null) {
            predicate.and(supply.feedAmount.loe(highAmount));
        }

        if (lowDate != null) {
            predicate.and(supply.supplyDate.after(lowDate));
        }

        if (highDate != null) {
            predicate.and(supply.supplyDate.before(highDate));
        }

        if (lowPrice != null) {
            predicate.and(supply.price.goe(lowPrice));
        }

        if (highPrice != null) {
            predicate.and(supply.price.loe(highPrice));
        }

        return from(supply)
                .where(predicate.getValue())
                .select(supply)
                .fetch();
    }
}
