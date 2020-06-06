package database.app_database.Dto;

import java.util.List;

public class AssortmentDto {
    private String providerName;
    private List<String> feeds;

    public List<String> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<String> feeds) {
        this.feeds = feeds;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
