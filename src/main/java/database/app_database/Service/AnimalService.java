package database.app_database.Service;

import database.app_database.Converter.AnimalConverter;
import database.app_database.Dao.AnimalDao;
import database.app_database.Dto.AnimalDto;
import database.app_database.Model.Animal.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class  AnimalService {
    @Autowired
    AnimalDao animalDao;

    @Autowired
    AnimalConverter animalConverter;

    @Transactional
    public List<AnimalDto> getAll() {
        List<Animal> recipes = animalDao.getAll();
        return recipes
                .stream()
                .map(animalConverter::convertBase)
                .collect(Collectors.toList());
    }
}