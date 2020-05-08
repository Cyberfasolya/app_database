package database.app_database.Controller;

import database.app_database.Dto.AnimalDto;
import database.app_database.Service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

    @RequestMapping(method = POST, value = "animal")
    public void create(@RequestBody final AnimalDto animalDto){
        animalService.create(animalDto);
    }
}