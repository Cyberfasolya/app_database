package database.app_database.Model.Employee.AccessWorker;

import database.app_database.Model.Animal.Animal;
import database.app_database.Model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "access")
public class Access implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "access_employee_id")
    private AccessWorker accessWorker;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @Column(name = "access_start_date")
    private Instant accessStartDate;
}
