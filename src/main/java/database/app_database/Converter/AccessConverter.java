package database.app_database.Converter;

import database.app_database.Dto.AccessDto;
import database.app_database.Model.Employee.AccessWorker.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccessConverter {
    @Autowired
    private AnimalConverter animalConverter;

    public AccessDto convert(Access access) {
        AccessDto accessDto = new AccessDto();

        accessDto.setAccessStartDate(access.getAccessStartDate());
        accessDto.setAnimal(animalConverter.convertBase(access.getAnimal()));
        //employee
        return accessDto;
    }

}
