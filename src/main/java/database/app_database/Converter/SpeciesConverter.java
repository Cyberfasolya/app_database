package database.app_database.Converter;

import database.app_database.Dto.SpeciesBaseDto;
import database.app_database.Dto.SpeciesDto;
import database.app_database.Model.Animal.Species;
import org.springframework.stereotype.Component;

@Component
public class SpeciesConverter {

    public SpeciesDto convertSpecies(Species species) {
        SpeciesDto dto = new SpeciesDto();
        dto.setId(species.getId());
        dto.setName(species.getName());
        dto.setType(species.getType());
        dto.setAgeForChildbirth(species.getAgeForChildbirth());
        dto.setNeedWarmPlace(species.isNeedWarmPlace());
        return dto;
    }

    public SpeciesBaseDto convertBase(Species species) {
        SpeciesBaseDto dto = new SpeciesBaseDto();
        dto.setId(species.getId());
        dto.setName(species.getName());
        return dto;
    }
}