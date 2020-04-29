package database.app_database.Model.Exchange;
import database.app_database.Model.Animal.Animal;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exchange")
public class Exchange implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zoo_id")
    private Zoo zoo;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @Column(name = "side")
    private boolean side;
}
