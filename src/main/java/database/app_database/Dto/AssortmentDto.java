package database.app_database.Dto;

import java.util.List;

public class AssortmentDto {
    private String providerName;
    private List<String> Feeds;

    public List<String> getFeeds() {
        return Feeds;
    }

    public void setFeeds(List<String> feeds) {
        Feeds = feeds;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
