package database.app_database.Dto;

public class MenuContentDto {
    private FeedDto feedDto;
    private int feedAmount;

    public FeedDto getFeedDto() {
        return feedDto;
    }

    public void setFeedDto(FeedDto feedDto) {
        this.feedDto = feedDto;
    }

    public int getFeedAmount() {
        return feedAmount;
    }

    public void setFeedAmount(int feedAmount) {
        this.feedAmount = feedAmount;
    }
}
