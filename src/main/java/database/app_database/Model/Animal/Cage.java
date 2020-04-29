package database.app_database.Model.Animal;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cage")
public class Cage {
    @Id
    private int id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "neighborhood", joinColumns = @JoinColumn(name = "first_cage_id"), inverseJoinColumns = @JoinColumn(name = "second_cage_id"))
    private List<Cage> cages = new ArrayList<>();

    @Column(name = "inmate")
    private boolean inmate;

}
