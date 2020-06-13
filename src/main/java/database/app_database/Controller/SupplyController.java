package database.app_database.Controller;

import database.app_database.Dto.SupplyDto;
import database.app_database.Service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping(method = POST, value = "supply")
    public void create(@RequestBody final SupplyDto supplyDto) {
        supplyService.create(supplyDto);
    }

    @RequestMapping(method = GET, value = "filter-supplies")
    public List<SupplyDto> getByBasicInfo(
            @RequestParam(required = false) String feedName,
            @RequestParam(required = false) Integer lowAmount,
            @RequestParam(required = false) Integer highAmount,
            @RequestParam(required = false) Integer lowPeriod,
            @RequestParam(required = false) Integer highPeriod,
            @RequestParam(required = false) Integer lowPrice,
            @RequestParam(required = false) Integer highPrice,
            @RequestParam(required = false) String feedNamePart,
            @RequestParam(required = false) String providerNamePart
    ) {
        return supplyService.getByBasicInfo(feedName, lowAmount, highAmount, lowPeriod, highPeriod, lowPrice, highPrice, feedNamePart, providerNamePart);
    }
}