package database.app_database.Service;

import database.app_database.Converter.MenuConverter;
import database.app_database.Converter.SpeciesConverter;
import database.app_database.Dao.FeedDao;
import database.app_database.Dao.MenuContentDao;
import database.app_database.Dao.MenuDao;
import database.app_database.Dao.SpeciesDao;
import database.app_database.Dto.MenuDto;
import database.app_database.Model.Feed.Menu.Menu;
import database.app_database.Model.Feed.Menu.MenuContent;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {
    @Autowired
    private MenuDao menuDao;

    @Autowired
    private MenuConverter menuConverter;

    @Autowired
    private SpeciesDao speciesDao;

    @Autowired
    private FeedDao feedDao;

    @Autowired
    private MenuContentDao menuContentDao;

    @Transactional
    public List<MenuDto> getAll() {
        List<Menu> menus = menuDao.getAll();
        return menus
                .stream()
                .map(menuConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(MenuDto menuDto) {
        Menu menu = new Menu();

        menu.setSeason(menuDto.getSeason());
        menu.setSpecies(speciesDao.getByName(menuDto.getSpeciesDto().getName()));
        menuDao.persist(menu);
        List<MenuContent> menuContents = menuDto.getMenuContents().stream()
                .map(menuContentDto -> {
                    MenuContent menuContent = new MenuContent();
                    menuContent.setMenu(menu);
                    menuContent.setFeedAmount(menuContentDto.getFeedAmount());
                    menuContent.setFeed(feedDao.getByName(menuContentDto.getFeedDto().getName()));
                    menuContentDao.persist(menuContent);
                    return menuContent;
                })
                .collect(Collectors.toList());
        menu.setMenuContents(menuContents);
    }

}
