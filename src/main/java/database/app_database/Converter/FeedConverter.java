package database.app_database.Converter;

import database.app_database.Dto.FeedAmountDto;
import database.app_database.Dto.FeedDto;
import database.app_database.Dto.ProviderFeedDto;
import database.app_database.Model.Feed.Feed;
import database.app_database.Model.Feed.Supply;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FeedConverter {

    public FeedDto convert(Feed feed) {
        FeedDto dto = new FeedDto();
        convert(feed, dto);
        return dto;
    }

    public ProviderFeedDto convertZoosFeeds(List<Supply> supplies, Integer numberOfZooSupplies) {
        ProviderFeedDto dto = new ProviderFeedDto();
        dto.setNumberOfZooSupplies(numberOfZooSupplies);
        var feeds = supplies
                .stream()
                .map(Supply::getFeed)
                .distinct()
                .collect(Collectors.toList());

        var feedAmountDtos = feeds.stream()
                .map(feed -> supplies.stream()
                        .filter(supply -> supply.getFeed().equals(feed))
                        .map(Supply::getFeedAmount)
                        .reduce(Integer::sum)
                        .map(sum -> {
                            var feedAmountDto = new FeedAmountDto();
                            convert(feed, feedAmountDto);
                            feedAmountDto.setAmount(sum.longValue());

                            return Optional.of(feedAmountDto);
                        })
                        .orElse(Optional.empty())
                )
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        dto.setFeeds(feedAmountDtos);

        return dto;
    }

    private void convert(Feed feed, FeedDto dto) {
        dto.setId(feed.getId());
        dto.setName(feed.getName());
        dto.setType(feed.getType());
    }
}