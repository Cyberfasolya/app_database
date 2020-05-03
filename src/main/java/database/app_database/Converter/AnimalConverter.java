package database.app_database.Converter;

import database.app_database.Dto.AnimalDto;
import database.app_database.Dto.SpeciesDto;
import database.app_database.Model.Animal.Animal;
import database.app_database.Model.Animal.Species;
import org.springframework.stereotype.Component;

@Component
public class AnimalConverter {

    public AnimalDto convertBase(Animal animal) {
        AnimalDto dto = new AnimalDto();
        dto.setId(animal.getId());
        dto.setCage(animal.getCage());
        dto.setDateOfBirth(animal.getDateOfBirth());
        dto.setGender(animal.getGender());
        dto.setName(animal.getName());
        dto.setReceiptDate(animal.getReceiptDate());
        dto.setNumberOfOffspring(animal.getNumberOfOffspring());
        dto.setSpecies(convertSpecies(animal.getSpecies()));
        return dto;
    }

    public SpeciesDto convertSpecies(Species species) {
        SpeciesDto dto = new SpeciesDto();
        dto.setId(species.getId());
        dto.setType(species.getType());
        dto.setAgeForChildbirth(species.isAgeForChildbirth());
        dto.setNeedWarmPlace(species.isNeedWarmPlace());
        return dto;
    }
}
