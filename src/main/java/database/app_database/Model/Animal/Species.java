package database.app_database.Model.Animal;
import database.app_database.Model.Feed.Menu.Menu;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "species")
@SequenceGenerator(name="sequence", initialValue=11, allocationSize=1)
public class Species {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequence")
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "compatibility", joinColumns = @JoinColumn(name = "first_species_id"), inverseJoinColumns = @JoinColumn(name = "second_species_id"))
    private List<Species> speciesList = new ArrayList<>();

    @OneToMany(mappedBy = "species", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Menu> menuList = new ArrayList<>();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "need_warm_place", nullable = false)
    private boolean needWarmPlace;

    @Column(name = "age_for_childbirth", nullable = false)
    private  int ageForChildbirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Species> getSpeciesList() {
        return speciesList;
    }

    public void setSpeciesList(List<Species> speciesList) {
        this.speciesList = speciesList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isNeedWarmPlace() {
        return needWarmPlace;
    }

    public void setNeedWarmPlace(boolean needWarmPlace) {
        this.needWarmPlace = needWarmPlace;
    }

    public int getAgeForChildbirth() {
        return ageForChildbirth;
    }

    public void setAgeForChildbirth(int ageForChildbirth) {
        this.ageForChildbirth = ageForChildbirth;
    }
}

