package database.app_database.Model.Employee.AccessWorker;

import javax.persistence.*;

@Entity
@Table(name = "trainer")
public class Trainer {
    @Id
    private int id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "access_worker_id")
    private AccessWorker access_worker;

    @Column(name = "hall_number")
    private int hall_number;
}