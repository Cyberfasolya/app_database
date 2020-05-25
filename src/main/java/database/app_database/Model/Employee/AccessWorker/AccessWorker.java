package database.app_database.Model.Employee.AccessWorker;

import database.app_database.Model.Employee.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "access_worker")
@PrimaryKeyJoinColumn(name = "employee_id")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AccessWorker extends Employee {

    @OneToMany(mappedBy = "accessWorker", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Access> accessList = new ArrayList<>();

}

