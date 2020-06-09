package database.app_database.Dao;

import database.app_database.Model.Feed.Menu.MenuContent;
import database.app_database.Model.Feed.Menu.QMenuContent;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Feed.Menu.QMenuContent.menuContent;


@Repository
public class MenuContentDao extends BaseEntityDao<MenuContent, QMenuContent> {

    public MenuContentDao() {
        super(menuContent);
    }
}
