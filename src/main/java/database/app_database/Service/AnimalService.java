package database.app_database.Service;

import database.app_database.Converter.AnimalConverter;
import database.app_database.Dao.AnimalDao;
import database.app_database.Dao.SpeciesDao;
import database.app_database.Dto.AnimalDto;
import database.app_database.Model.Animal.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {
    @Autowired
    private AnimalDao animalDao;

    @Autowired
    private AnimalConverter animalConverter;

    @Autowired
    private SpeciesDao speciesDao;

    @Transactional
    public List<AnimalDto> getAll() {
        List<Animal> animals = animalDao.getAll();
        return animals
                .stream()
                .map(animalConverter::convertBase)
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(AnimalDto animalDto){
        Animal animal = animalDao.persist(new Animal());
        animal.setName(animalDto.getName());
        animal.setCage(animalDto.getCage());
        animal.setDateOfBirth(Instant.parse(animalDto.getDateOfBirth()));
        animal.setReceiptDate(Instant.parse(animalDto.getReceiptDate()));
        animal.setGender(animalDto.getGender());
        animal.setNumberOfOffspring(animal.getNumberOfOffspring());
        animal.setSpecies(speciesDao.get(animalDto.getSpecies().getId()));
    }

}