package database.app_database.Model.Feed.Menu;
import database.app_database.Model.Animal.Species;
import database.app_database.Model.BaseObject;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu extends BaseObject {
    @Id
    private Integer id;

    @Column(name = "season", nullable = false)
    private String season;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "species_id")
    private Species species;

    @Override
    public Integer getId() {
        return id;
    }
}


