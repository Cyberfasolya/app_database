package database.app_database.Model.Exchange;
import database.app_database.Model.BaseObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zoo")
public class Zoo extends BaseObject {
    @Id
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "zoo", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Exchange> exchangeList = new ArrayList<>();

    @Override
    public Integer getId() {
        return null;
    }
}
