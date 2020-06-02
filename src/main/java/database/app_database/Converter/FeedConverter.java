package database.app_database.Converter;

import database.app_database.Dto.FeedDto;
import database.app_database.Model.Feed.Feed;
import org.springframework.stereotype.Component;

@Component
public class FeedConverter {

    public FeedDto convert(Feed feed) {
        FeedDto dto = new FeedDto();
        dto.setId(feed.getId());
        dto.setName(feed.getName());
        dto.setType(feed.getType());
        return dto;
    }
}