package database.app_database.Model.Feed.Menu;

import database.app_database.Model.Animal.Species;
import database.app_database.Model.BaseObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu")
@SequenceGenerator(name = "seq_menu", initialValue = 12, allocationSize = 1)
public class Menu extends BaseObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_menu")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "season", nullable = false)
    private String season;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "species_id")
    private Species species;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MenuContent> menuContents = new ArrayList<>();

    @Override
    public Integer getId() {
        return id;
    }

    public List<MenuContent> getMenuContents() {
        return menuContents;
    }

    public void setMenuContents(List<MenuContent> menuContents) {
        this.menuContents = menuContents;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}


