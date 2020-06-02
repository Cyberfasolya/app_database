package database.app_database.Dao;

import database.app_database.Model.Feed.Provider;
import database.app_database.Model.Feed.QProvider;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Feed.QProvider.provider;

import java.util.List;

@Repository
public class ProviderDao extends BaseEntityDao<Provider, QProvider> {

    public ProviderDao() {
        super(provider);
    }

    public List<Provider> getAll() {
        return from(provider)
                .select(provider)
                .fetch();
    }
}