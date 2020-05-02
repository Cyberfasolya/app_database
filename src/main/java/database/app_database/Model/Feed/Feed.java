package database.app_database.Model.Feed;
import database.app_database.Model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "feed")
public class Feed extends BaseObject {
    @Id
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "assortment", joinColumns = @JoinColumn(name = "feed_id"), inverseJoinColumns = @JoinColumn(name = "provider_id"))
    private List<Provider> providers = new ArrayList<>();

    @OneToMany(mappedBy = "feed", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Supply> supplies = new ArrayList<>();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Override
    public Integer getId() {
        return id;
    }
}

