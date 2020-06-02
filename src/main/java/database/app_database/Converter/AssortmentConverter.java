package database.app_database.Converter;

import database.app_database.Dto.AssortmentDto;
import database.app_database.Model.Feed.Feed;
import database.app_database.Model.Feed.Provider;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AssortmentConverter {

    public AssortmentDto convert(Provider provider) {
        AssortmentDto dto = new AssortmentDto();
        var feeds = provider.getFeedList().stream().map(Feed::getName).collect(Collectors.toList());
        dto.setFeeds(feeds);
        dto.setProviderName(provider.getName());
        return dto;
    }
}
