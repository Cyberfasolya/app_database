package database.app_database.Dao;

import database.app_database.Model.Animal.Animal;
import database.app_database.Model.Animal.QAnimal;
import org.springframework.stereotype.Repository;
import static database.app_database.Model.Animal.QAnimal.animal;

import java.util.List;

@Repository
public class AnimalDao extends BaseEntityDao<Animal, QAnimal> {

    public AnimalDao() {
        super(animal);
    }

    public List<Animal> getAll() {
        return from(animal)
                .select(animal)
                .fetch();
    }

}