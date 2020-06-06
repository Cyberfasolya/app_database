package database.app_database.Dao;

import database.app_database.Model.Feed.QSupply;
import database.app_database.Model.Feed.Supply;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Feed.QSupply.supply;

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
}
