package database.app_database.Service;

import database.app_database.Converter.MenuConverter;
import database.app_database.Dao.MenuDao;
import database.app_database.Dto.MenuDto;
import database.app_database.Model.Feed.Menu.Menu;
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

    @Transactional
    public List<MenuDto> getAll() {
        List<Menu> menus = menuDao.getAll();
        return menus
                .stream()
                .map(menuConverter::convert)
                .collect(Collectors.toList());
    }

}
