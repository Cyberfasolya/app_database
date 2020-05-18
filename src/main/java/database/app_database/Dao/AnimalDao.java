package database.app_database.Dao;

import com.querydsl.core.BooleanBuilder;
import database.app_database.Model.Animal.Animal;
import database.app_database.Model.Animal.QAnimal;
import database.app_database.Model.Animal.Species;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Animal.QAnimal.animal;
import static database.app_database.Model.Animal.QSpecies.species;

import java.time.Instant;
import java.util.List;


@Repository
public class AnimalDao extends BaseEntityDao<Animal, QAnimal> {

    public AnimalDao() {
        super(animal);
    }

    public List<Animal> getAll(Integer speciesId, String gender, Instant lowDate, Instant highDate) {
        var predicate = new BooleanBuilder();
        if (speciesId != null) {
            predicate.and(animal.species.id.eq(speciesId));
        }

        if (gender != null) {
            predicate.and(animal.gender.eq(gender));
        }

        if (lowDate != null) {
            predicate.and(animal.dateOfBirth.after(lowDate));
        }

        if (highDate != null) {
            predicate.and(animal.dateOfBirth.before(highDate));
        }


        return from(animal)
                .where(predicate.getValue())
                .select(animal)
                .fetch();
    }

    public List<Animal> getNeedWarmPlaceAndCompatibleAnimals(Species chosenSpecies, Boolean needWarmPlace) {
        var predicate = new BooleanBuilder();
        if (chosenSpecies != null) {
            predicate.and(animal.species.in(chosenSpecies.getSpeciesList()));
        }

        if (needWarmPlace != null) {
            predicate.and(animal.species.needWarmPlace.eq(needWarmPlace));
        }

        return from(animal)
                .where(predicate.getValue())
                .select(animal)
                .fetch();
    }
}