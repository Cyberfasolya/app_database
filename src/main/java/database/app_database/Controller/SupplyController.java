package database.app_database.Controller;

import database.app_database.Dto.SupplyDto;
import database.app_database.Service.SupplyService;
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
public class SupplyController {
    @Autowired
    private SupplyService supplyService;

    @RequestMapping(method = GET, value = "supplies")
    public List<SupplyDto> getAll() {
        return supplyService.getAll();
    }

}