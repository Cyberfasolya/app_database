package database.app_database.Dao;

import com.querydsl.core.BooleanBuilder;
import database.app_database.Model.Feed.Menu.Menu;
import database.app_database.Model.Feed.Menu.QMenu;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Feed.Menu.QMenu.menu;
import static database.app_database.Model.Feed.Menu.QMenuContent.menuContent;

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

    public List<Menu> getByFeedTypeAndSeason(String feedType, String season) {
        var predicate = new BooleanBuilder();
        if (season != null) {
            predicate.and(menu.season.eq(season));
        }

        if (feedType != null) {
            predicate.and(menuContent.feed.type.eq(feedType));
        }

        return from(menuContent)
                .join(menu).on(menuContent.menu.eq(menu))
                .where(predicate.getValue())
                .select(menu)
                .distinct()
                .fetch();
    }
}
