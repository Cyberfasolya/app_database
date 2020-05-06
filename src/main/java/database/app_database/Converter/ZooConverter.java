package database.app_database.Converter;

import database.app_database.Dto.ZooDto;
import database.app_database.Model.Exchange.Zoo;
import org.springframework.stereotype.Component;

@Component
public class ZooConverter {

    public ZooDto convert(Zoo zoo){
        ZooDto dto = new ZooDto();

        dto.setId(zoo.getId());
        dto.setName(zoo.getName());

        return dto;
    }
}
