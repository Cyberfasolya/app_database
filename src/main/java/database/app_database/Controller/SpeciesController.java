package database.app_database.Controller;

import database.app_database.Dto.SpeciesBaseDto;
import database.app_database.Dto.SpeciesDto;
import database.app_database.Service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class SpeciesController {
    @Autowired
    private SpeciesService speciesService;

    @RequestMapping(method = GET, value = "species")
    public List<SpeciesBaseDto> getAll() {
        return speciesService.getAll();
    }

}