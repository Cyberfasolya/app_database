package database.app_database.Controller;

import database.app_database.Dto.ProviderDto;
import database.app_database.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping(method = GET, value = "filter-providers")
    public List<ProviderDto> getByBasicInfo(
            @RequestParam(required = false) String feedName,
            @RequestParam(required = false) Integer lowAmount,
            @RequestParam(required = false) Integer highAmount,
            @RequestParam(required = false) Integer lowPeriod,
            @RequestParam(required = false) Integer highPeriod,
            @RequestParam(required = false) Integer lowPrice,
            @RequestParam(required = false) Integer highPrice
    ) {
        return providerService.getByBasicInfo(feedName, lowAmount, highAmount, lowPeriod, highPeriod, lowPrice, highPrice);
    }


}