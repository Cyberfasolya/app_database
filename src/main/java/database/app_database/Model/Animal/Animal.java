package database.app_database.Model.Animal;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cage_id")
    private Cage cage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "species_id")
    private Species species;

    @Column(name = " date_of_birth", nullable = false)
    private Instant date_of_birth;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "physical_state", nullable =  false)
    private boolean physical_state;

    @Column(name = "hospital")
    private boolean hospital;

    @Column(name = "reciept_date", nullable =  false)
    private Instant reciept_date;

    @Column(name = "number_of_offspring")
    private int number_of_offspring;
}




