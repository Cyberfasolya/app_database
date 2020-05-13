package database.app_database.Service;

import database.app_database.Converter.SpeciesConverter;
import database.app_database.Dao.SpeciesDao;
import database.app_database.Dto.SpeciesBaseDto;
import database.app_database.Dto.SpeciesDto;
import database.app_database.Model.Animal.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpeciesService {
    @Autowired
    private SpeciesDao speciesDao;

    @Autowired
    private SpeciesConverter speciesConverter;

    @Transactional
    public List<SpeciesBaseDto> getAll() {
        List<Species> species = speciesDao.getAll();
        return species
                .stream()
                .map(speciesConverter::convertBase)
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(SpeciesDto speciesDto) {
        Species species = new Species();

        species.setName(speciesDto.getName());
        species.setType(speciesDto.getType());
        species.setAgeForChildbirth(speciesDto.getAgeForChildbirth());
        species.setNeedWarmPlace(speciesDto.isNeedWarmPlace());

        species.setSpeciesList(speciesDto.getSpeciesList()
                .stream()
                .map(dto -> speciesDao.get(dto.getId()))
                .collect(Collectors.toList()));

        speciesDao.persist(species);
    }
}