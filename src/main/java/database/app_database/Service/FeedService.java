package database.app_database.Service;

import database.app_database.Converter.FeedConverter;
import database.app_database.Dao.FeedDao;
import database.app_database.Dto.FeedDto;
import database.app_database.Model.Feed.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedService {
    @Autowired
    private FeedDao feedDao;

    @Autowired
    private FeedConverter feedConverter;

    @Transactional
    public List<FeedDto> getAll() {
        List<Feed> feeds = feedDao.getAll();
        return feeds
                .stream()
                .map(feedConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(FeedDto feedDto) {
        Feed feed = new Feed();

        feed.setName(feedDto.getName());
        feed.setType(feedDto.getType());
        feedDao.persist(feed);
    }
}
