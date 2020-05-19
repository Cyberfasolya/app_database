package database.app_database.Service;

import database.app_database.Converter.ExchangeConverter;
import database.app_database.Dao.AnimalDao;
import database.app_database.Dao.ExchangeDao;
import database.app_database.Dao.SpeciesDao;
import database.app_database.Dao.ZooDao;
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

    @Autowired
    private AnimalDao animalDao;

    @Autowired
    private SpeciesDao speciesDao;

    @Autowired
    private ZooDao zooDao;

    @Transactional
    public List<ExchangeDto> getAll() {
        List<Exchange> exchanges = exchangeDao.getAll();
        return exchanges
                .stream()
                .map(exchangeConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(ExchangeDto exchangeDto) {
        Exchange exchange = new Exchange();

        exchange.setZoo(zooDao.get(exchangeDto.getZoo().getId()));
        exchange.setAnimal(animalDao.getByNameAndSpecies(exchangeDto.getAnimal().getName(),
                speciesDao.get(exchangeDto.getAnimal().getSpecies().getId())));
        exchange.setSide(exchangeDto.isSide());

        exchangeDao.persist(exchange);
    }
}