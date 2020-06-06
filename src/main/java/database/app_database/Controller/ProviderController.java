package database.app_database.Controller;

import database.app_database.Dto.ProviderDto;
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
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @RequestMapping(method = GET, value = "providers")
    public List<ProviderDto> getAll() {
        return providerService.getAll();
    }

    @RequestMapping(method = POST, value = "provider")
    public void create(@RequestBody final ProviderDto providerDto) {
        providerService.create(providerDto);
    }

}