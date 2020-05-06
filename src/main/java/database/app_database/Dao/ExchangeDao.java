package database.app_database.Dao;

import database.app_database.Model.Exchange.Exchange;
import database.app_database.Model.Exchange.QExchange;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Exchange.QExchange.exchange;

import java.util.List;

@Repository
public class ExchangeDao extends BaseEntityDao<Exchange, QExchange> {

    public ExchangeDao() {
        super(exchange);
    }

    public List<Exchange> getAll() {
        return from(exchange)
                .select(exchange)
                .fetch();
    }
}