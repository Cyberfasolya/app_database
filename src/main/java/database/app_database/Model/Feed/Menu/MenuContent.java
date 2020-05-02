package database.app_database.Model.Feed.Menu;
import database.app_database.Model.Feed.Feed;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "menu_content")
public class MenuContent implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @Column(name = "feed_amount", nullable = false)
    private int feedAmount;

}
