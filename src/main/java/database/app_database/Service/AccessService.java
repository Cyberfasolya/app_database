package database.app_database.Service;

import database.app_database.Converter.AccessConverter;
import database.app_database.Dao.AccessDao;
import database.app_database.Dao.AccessWorkerDao;
import database.app_database.Dao.AnimalDao;
import database.app_database.Dao.SpeciesDao;
import database.app_database.Dto.AccessDto;
import database.app_database.Model.Employee.AccessWorker.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessService {
    @Autowired
    private AccessDao accessDao;

    @Autowired
    private AccessConverter accessConverter;

    @Autowired
    private AnimalDao animalDao;

    @Autowired
    private SpeciesDao speciesDao;

    @Autowired
    private AccessWorkerDao accessWorkerDao;

    @Transactional
    public List<AccessDto> getAll() {
        List<Access> accesses = accessDao.getAll();
        return accesses
                .stream()
                .map(accessConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(AccessDto accessDto) {
        Access access = new Access();

        LocalDate accessStartDate = LocalDate.parse(accessDto.getAccessStartDate());

        access.setAnimal(animalDao.getByNameAndSpecies(accessDto.getAnimalName(), speciesDao.getByName(accessDto.getSpecies())));
        access.setAccessStartDate(accessStartDate.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant());
        access.setAccessWorker(accessWorkerDao.getByNameAndSurname(accessDto.getEmployeeName(), accessDto.getEmployeeSurname()));

        accessDao.persist(access);
    }
}