package database.app_database.Model.Employee;

import database.app_database.Dao.Roles;

import javax.persistence.*;

@Entity
@Table(name = "builder_worker")
@PrimaryKeyJoinColumn(name = "employee_id")
public class BuilderWorker extends Employee {

    private final static Roles role = Roles.builderWorker;

    @Column(name = "building_for_repair")
    private int buildingForRepair;

    @Override
    public <T> T accept(EmployeeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int getBuildingForRepair() {
        return buildingForRepair;
    }

    public void setBuildingForRepair(int buildingForRepair) {
        this.buildingForRepair = buildingForRepair;
    }

    @Override
    public Roles getRole() {
        return role;
    }
}




