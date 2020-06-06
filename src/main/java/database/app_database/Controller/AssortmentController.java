package database.app_database.Controller;

import database.app_database.Dto.AssortmentDto;
import database.app_database.Service.AssortmentService;
import database.app_database.Service.ExchangeService;
import database.app_database.Service.ProviderService;
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
public class AssortmentController {
    @Autowired
    private AssortmentService assortmentService;

    @Autowired
    private ProviderService providerService;

    @RequestMapping(method = GET, value = "assortments")
    public List<AssortmentDto> getAll() {
        return assortmentService.getAll();
    }

    @RequestMapping(method = POST, value = "assortment")
    public void create(@RequestBody final AssortmentDto assortmentDto) {
        providerService.addAssortment(assortmentDto);
    }
}