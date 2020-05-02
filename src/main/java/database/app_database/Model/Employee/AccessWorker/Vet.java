package database.app_database.Model.Employee.AccessWorker;
import javax.persistence.*;

@Entity
@Table(name = "vet")
public class Vet {
    @Id
    private int id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "access_worker_id")
    private AccessWorker accessWorker;

    @Column(name = "laboratory_number")
    private int laboratoryNumber;
}