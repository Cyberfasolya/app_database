package database.app_database.Service;

import database.app_database.Converter.ExchangeConverter;
import database.app_database.Dao.ExchangeDao;
import database.app_database.Dto.ExchangeDto;
import database.app_database.Model.Exchange.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExchangeService {
    @Autowired
    private ExchangeDao exchangeDao;

    @Autowired
    private ExchangeConverter exchangeConverter;

    @Transactional
    public List<ExchangeDto> getAll() {
        List<Exchange> recipes = exchangeDao.getAll();
        return recipes
                .stream()
                .map(exchangeConverter::convert)
                .collect(Collectors.toList());
    }
}