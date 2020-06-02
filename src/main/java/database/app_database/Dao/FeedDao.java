package database.app_database.Dao;

import database.app_database.Model.Feed.Feed;
import database.app_database.Model.Feed.QFeed;
import org.springframework.stereotype.Repository;

import static database.app_database.Model.Feed.QFeed.feed;

import java.util.List;

@Repository
public class FeedDao extends BaseEntityDao<Feed, QFeed> {

    public FeedDao() {
        super(feed);
    }

    public List<Feed> getAll() {
        return from(feed)
                .select(feed)
                .fetch();
    }
}
