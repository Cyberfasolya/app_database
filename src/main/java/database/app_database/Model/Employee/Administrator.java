package database.app_database.Model.Employee;
import javax.persistence.*;

@Entity
@Table(name = "administration_worker")
public class Administrator {
    @Id
    private int id;

    @OneToOne( fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "cabinet_number")
    private int cabinetNumber;
}