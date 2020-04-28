package database.app_database.Model.Animal;

import javax.persistence.*;

@Entity
@Table(name = "cage")
public class Cage {
    @Id
    private int id;

    @Column(name = "inmate")
    private boolean inmate;

}
