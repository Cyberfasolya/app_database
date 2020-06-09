package database.app_database.Dao;

import database.app_database.Model.Feed.Menu.Menu;
import database.app_database.Model.Feed.Menu.QMenu;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Feed.Menu.QMenu.menu;

import java.util.List;

@Repository
public class MenuDao extends BaseEntityDao<Menu, QMenu> {

    public MenuDao() {
        super(menu);
    }

    public List<Menu> getAll() {
        return from(menu)
                .select(menu)
                .fetch();
    }
}
