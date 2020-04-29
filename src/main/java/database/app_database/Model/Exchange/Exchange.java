package database.app_database.Model.Exchange;
import database.app_database.Model.Animal.Animal;

import javax.persistence.*;

@Entity
@Table(name = "exchange")
public class Exchange {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zoo_id")
    private Zoo zoo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @Column(name = "side")
    private boolean side;
}
