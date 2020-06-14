package database.app_database.Dto;

import java.util.List;
import java.util.Map;

public class ProviderFeedDto {
    private List<FeedAmountDto> feeds;
    private Integer numberOfZooSupplies;

    public List<FeedAmountDto> getFeeds() {
        return feeds;
    }

    public Integer getNumberOfZooSupplies() {
        return numberOfZooSupplies;
    }

    public void setNumberOfZooSupplies(Integer numberOfZooSupplies) {
        this.numberOfZooSupplies = numberOfZooSupplies;
    }

    public void setFeeds(List<FeedAmountDto> feeds) {
        this.feeds = feeds;
    }
}
