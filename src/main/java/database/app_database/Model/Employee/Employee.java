package database.app_database.Model.Employee;
import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "work_start_date", nullable = false)
    private Instant work_start_date;

    @Column(name = "monthly_salary", nullable = false)
    private int monthly_salary;
}



