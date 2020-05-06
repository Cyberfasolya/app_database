package database.app_database.Controller;

import database.app_database.Dto.ExchangeDto;
import database.app_database.Service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    @RequestMapping(method = GET, value = "exchanges")
    public List<ExchangeDto> getAll() {
        return exchangeService.getAll();
    }

}