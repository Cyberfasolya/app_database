package database.app_database.Model.Employee;
import javax.persistence.*;

@Entity
@Table(name = "builder_worker")
@PrimaryKeyJoinColumn(name = "employee_id")
public class BuilderWorker extends Employee {
    @Id
    private int id;

    @Column(name = "building_for_repair")
    private int buildingForRepair;
}




