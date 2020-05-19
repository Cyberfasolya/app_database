package database.app_database.Model.Exchange;

import database.app_database.Model.BaseObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zoo")
@SequenceGenerator(name = "zoo_seq", initialValue = 11, allocationSize = 1)
public class Zoo extends BaseObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zoo_seq")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "zoo", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Exchange> exchangeList = new ArrayList<>();

    @Override
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
