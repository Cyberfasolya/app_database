package database.app_database.Model.Employee;
import javax.persistence.*;

@Entity
@Table(name = "builder_worker")
@PrimaryKeyJoinColumn(name = "employee_id")
public class BuilderWorker extends Employee {

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
}




