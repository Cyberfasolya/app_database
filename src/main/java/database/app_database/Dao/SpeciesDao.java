package database.app_database.Dao;

import database.app_database.Model.Animal.QSpecies;
import database.app_database.Model.Animal.Species;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Animal.QSpecies.species;

import java.util.List;

@Repository
public class SpeciesDao extends BaseEntityDao<Species, QSpecies> {

    public SpeciesDao() {
        super(species);
    }

    public List<Species> getAll() {
        return from(species)
                .select(species)
                .fetch();
    }
}