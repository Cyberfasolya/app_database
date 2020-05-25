package database.app_database.Controller;

import database.app_database.Dto.AccessDto;
import database.app_database.Service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class AccessController {
    @Autowired
    private AccessService accessService;

    @RequestMapping(method = GET, value = "accesses")
    public List<AccessDto> getAll() {
        return accessService.getAll();
    }

}