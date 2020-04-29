package database.app_database.Model.Animal;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "species")
public class Species {
    @Id
    private int id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "compatibility", joinColumns = @JoinColumn(name = "first_species_id"), inverseJoinColumns = @JoinColumn(name = "second_species_id"))
    private List<Species> speciesList = new ArrayList<>();

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "need_warm_place", nullable = false)
    private boolean need_warm_place;

    @Column(name = "age_for_childbirth", nullable = false)
    private  boolean age_for_childbirth;

}

