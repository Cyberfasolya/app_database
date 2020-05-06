package database.app_database.Converter;

import database.app_database.Dto.ExchangeDto;
import database.app_database.Model.Exchange.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExchangeConverter {
    @Autowired
    private AnimalConverter animalConverter;

    @Autowired
    private ZooConverter zooConverter;

    public ExchangeDto convert(Exchange exchange){
        ExchangeDto dto = new ExchangeDto();

        dto.setSide(exchange.isSide());
        dto.setAnimal(animalConverter.convertBase(exchange.getAnimal()));
        dto.setZoo(zooConverter.convert(exchange.getZoo()));
        return dto;
    }
}