package database.app_database.Dto;


import liquibase.pro.packaged.S;

public class SupplyDto {
    private int id;
    private String providerName;
    private String feedName;
    private int price;
    private String supplyDate;
    private int feedAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getFeedName() {
        return feedName;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(String supplyDate) {
        this.supplyDate = supplyDate;
    }

    public int getFeedAmount() {
        return feedAmount;
    }

    public void setFeedAmount(int amount) {
        this.feedAmount = amount;
    }
}
