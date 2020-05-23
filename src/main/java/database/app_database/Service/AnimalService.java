package database.app_database.Service;

import database.app_database.Converter.AnimalConverter;
import database.app_database.Dao.AnimalDao;
import database.app_database.Dao.SpeciesDao;
import database.app_database.Dto.AnimalDto;
import database.app_database.Model.Animal.Animal;
import database.app_database.Model.Animal.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
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
    public List<AnimalDto> getByBasicInfo(Integer speciesId, String gender, Integer lowAge, Integer highAge, Integer cage) {
        Instant highDate = lowAge == null ? null : ZonedDateTime.now().minusYears(lowAge).toInstant();
        Instant lowDate = highAge == null ? null : ZonedDateTime.now().minusYears(highAge).toInstant();
        List<Animal> animals = animalDao.getByBasicInfo(speciesId, gender, lowDate, highDate, cage);
        return animals
                .stream()
                .map(animalConverter::convertBase)
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(AnimalDto animalDto) {
        Animal animal = new Animal();

        LocalDate dateOfBirth = LocalDate.parse(animalDto.getDateOfBirth());
        LocalDate receiptDate = LocalDate.parse(animalDto.getReceiptDate());

        animal.setName(animalDto.getName());
        animal.setCage(animalDto.getCage());
        animal.setDateOfBirth(dateOfBirth.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant());
        animal.setReceiptDate(receiptDate.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant());
        animal.setGender(animalDto.getGender());
        animal.setNumberOfOffspring(animalDto.getNumberOfOffspring());
        animal.setSpecies(speciesDao.get(animalDto.getSpecies().getId()));
        animalDao.persist(animal);
    }

    @Transactional
    public List<AnimalDto> getNeedWarmPlaceAndCompatibleAnimals(Integer speciesId, Boolean needWarmPlace) {
        Species species = speciesId != null ? speciesDao.get(speciesId) : null;
        List<Animal> animals = animalDao.getNeedWarmPlaceAndCompatibleAnimals(species, needWarmPlace);
        return animals
                .stream()
                .map(animalConverter::convertBase)
                .collect(Collectors.toList());
    }

}