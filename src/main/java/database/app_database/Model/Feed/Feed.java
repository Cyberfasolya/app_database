package database.app_database.Model.Feed;

import database.app_database.Model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "feed")
@SequenceGenerator(name = "seq_feed", initialValue = 11, allocationSize = 1)
public class Feed extends BaseObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_feed")
    @Column(name = "id", nullable = false)
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

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Provider> getProviders() {
        return providers;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addProvider(Provider provider) {
        if (!providers.contains(provider)) {
            //this.providers.add(provider);
        }
    }
}

