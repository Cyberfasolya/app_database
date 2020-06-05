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

        accessDto.setAccessStartDate(access.getAccessStartDate().toString());
        accessDto.setEmployeeName(access.getAccessWorker().getName());
        accessDto.setEmployeeSurame(access.getAccessWorker().getSurname());
        accessDto.setAnimalName(access.getAnimal().getName());
        accessDto.setSpecies(access.getAnimal().getSpecies().getName());

        return accessDto;
    }

}
