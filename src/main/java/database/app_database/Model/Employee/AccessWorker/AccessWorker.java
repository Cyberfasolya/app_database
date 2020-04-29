package database.app_database.Model.Employee.AccessWorker;
import database.app_database.Model.BaseObject;
import database.app_database.Model.Employee.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "access_worker")
public class AccessWorker extends BaseObject {
    @Id
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "accessWorker", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Access> accessList = new ArrayList<>();

    @Override
    public Integer getId() {
        return id;
    }

}

