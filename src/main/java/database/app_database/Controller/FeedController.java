package database.app_database.Controller;

import database.app_database.Dto.FeedDto;
import database.app_database.Service.FeedService;
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
public class FeedController {
    @Autowired
    private FeedService feedService;

    @RequestMapping(method = GET, value = "feeds")
    public List<FeedDto> getAll() {
        return feedService.getAll();
    }

    @RequestMapping(method = POST, value = "feed")
    public void create(@RequestBody final FeedDto feedDto) {
        feedService.create(feedDto);
    }
}
