package database.app_database.Model.Feed;
import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "supply")
public class Supply {
    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @Column(name = "supply_date", nullable =  false)
    private Instant supply_date;

    @Column(name = "feed_amount", nullable = false)
    private int feed_amount;

    @Column(name = "price", nullable = false)
    private int price;

}

