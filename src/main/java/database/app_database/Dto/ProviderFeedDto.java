package database.app_database.Dto;

import java.util.List;
import java.util.Map;

public class ProviderFeedDto {
    private List<FeedAmountDto> feeds;

    public List<FeedAmountDto> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<FeedAmountDto> feeds) {
        this.feeds = feeds;
    }
}
