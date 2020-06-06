package database.app_database.Model.Feed;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "provider")
public class Provider {
    @Id
    private int id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "assortment", joinColumns = @JoinColumn(name = "provider_id"), inverseJoinColumns = @JoinColumn(name = "feed_id"))
    private List<Feed> feedList = new ArrayList<>();

    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Supply> supplies = new ArrayList<>();

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Feed> getFeedList() {
        return feedList;
    }

    public void addFeed(Feed feed) {
        if (!feedList.contains(feed)) {
            this.feedList.add(feed);
            feed.addProvider(this);
        }
    }

    public List<Supply> getSupplies() {
        return supplies;
    }

    public void setSupplies(List<Supply> supplies) {
        this.supplies = supplies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
