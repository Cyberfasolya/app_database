package database.app_database.Model.Employee.AccessWorker;
import javax.persistence.*;

@Entity
@Table(name = "cleaner")
public class Cleaner {
    @Id
    private int id;

    @OneToOne(mappedBy = "cleaner", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "access_worker_id")
    private AccessWorker access_worker;

    @Column(name = "pantry_number")
    private int pantry_number;
}