package database.app_database.Model.Employee;
import javax.persistence.*;

@Entity
@Table(name = "builder_worker")
public class BuilderWorker {
    @Id
    private int id;

    @OneToOne(mappedBy = "builder_worker", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "building_for_repair")
    private int building_for_repair;
}




