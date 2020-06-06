package database.app_database.Model.Feed;
import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "supply")
@SequenceGenerator(name = "seq_supply", initialValue = 101, allocationSize = 1)
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_supply")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @Column(name = "supply_date", nullable =  false)
    private Instant supplyDate;

    @Column(name = "feed_amount", nullable = false)
    private int feedAmount;

    @Column(name = "price", nullable = false)
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public Instant getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(Instant supplyDate) {
        this.supplyDate = supplyDate;
    }

    public int getFeedAmount() {
        return feedAmount;
    }

    public void setFeedAmount(int feedAmount) {
        this.feedAmount = feedAmount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

