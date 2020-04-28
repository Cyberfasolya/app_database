package database.app_database.Model.Employee.AccessWorker;
import database.app_database.Model.Employee.Employee;
import javax.persistence.*;

@Entity
@Table(name = "access_worker")
public class AccessWorker {
    @Id
    private int id;

    @OneToOne(mappedBy = "access_worker", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}

