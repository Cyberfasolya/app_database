package database.app_database.Controller;

import database.app_database.Dto.MenuDto;
import database.app_database.Service.MenuService;
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
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(method = GET, value = "menus")
    public List<MenuDto> getAll() {
        return menuService.getAll();
    }

    @RequestMapping(method = POST, value = "menu")
    public void create(@RequestBody final MenuDto menuDto) {
        menuService.create(menuDto);
    }

}