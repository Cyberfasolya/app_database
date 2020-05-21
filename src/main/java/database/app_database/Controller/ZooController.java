package database.app_database.Controller;

import database.app_database.Dto.SpeciesDto;
import database.app_database.Dto.ZooDto;
import database.app_database.Service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class ZooController {
    @Autowired
    private ZooService zooService;

    @RequestMapping(method = GET, value = "zoos")
    public List<ZooDto> getAll(@RequestParam(required = false) Integer speciesId) {
        return zooService.getAll(speciesId);
    }

    @RequestMapping(method = POST, value = "zoo")
    public void create(@RequestBody final ZooDto zooDto) {
        zooService.create(zooDto);
    }

}