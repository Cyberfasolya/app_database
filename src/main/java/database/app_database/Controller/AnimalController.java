package database.app_database.Controller;

import database.app_database.Dto.AnimalDto;
import database.app_database.Service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @RequestMapping(method = GET, value = "animals")
    public List<AnimalDto> getAll() {
        return animalService.getAll();
    }

    @RequestMapping(method = GET, value = "animals/filter-by-basic-info")
    public List<AnimalDto> getByBasicInfo(@RequestParam(required = false) Integer speciesId,
                                          @RequestParam(required = false) String gender,
                                          @RequestParam(required = false) Integer lowAge,
                                          @RequestParam(required = false) Integer highAge,
                                          @RequestParam(required = false) Integer cage) {
        return animalService.getByBasicInfo(speciesId, gender, lowAge, highAge, cage);
    }

    @RequestMapping(method = GET, value = "animals/filter-by-species-info")
    public List<AnimalDto> getNeedWarmPlaceAndCompatibleAnimals(@RequestParam(required = false) Integer speciesId,
                                                                @RequestParam(required = false) Boolean needWarmPlace) {
        return animalService.getNeedWarmPlaceAndCompatibleAnimals(speciesId, needWarmPlace);
    }

    @RequestMapping(method = POST, value = "animal")
    public void create(@RequestBody final AnimalDto animalDto) {
        animalService.create(animalDto);
    }
}