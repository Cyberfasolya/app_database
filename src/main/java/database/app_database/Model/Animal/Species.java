package database.app_database.Model.Animal;
import javax.persistence.*;

@Entity
@Table(name = "species")
public class Species {
    @Id
    private int id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "need_warm_place", nullable = false)
    private boolean need_warm_place;

    @Column(name = "age_for_childbirth", nullable = false)
    private  boolean age_for_childbirth;

}

