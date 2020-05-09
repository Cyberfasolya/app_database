package database.app_database.Converter;

import database.app_database.Dto.AnimalDto;
import database.app_database.Model.Animal.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnimalConverter {
    @Autowired
    private SpeciesConverter speciesConverter;

    public AnimalDto convertBase(Animal animal) {
        AnimalDto dto = new AnimalDto();
        dto.setId(animal.getId());
        dto.setCage(animal.getCage());
        dto.setDateOfBirth(animal.getDateOfBirth().toString());
        dto.setGender(animal.getGender());
        dto.setName(animal.getName());
        dto.setReceiptDate(animal.getReceiptDate().toString());
        dto.setNumberOfOffspring(animal.getNumberOfOffspring());
        dto.setSpecies(speciesConverter.convertSpecies(animal.getSpecies()));
        return dto;
    }
}
