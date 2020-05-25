package database.app_database.Model.Employee;

import javax.persistence.*;

@Entity
@Table(name = "administration_worker")
@PrimaryKeyJoinColumn(name = "employee_id")
public class Administrator extends Employee {
    @Column(name = "cabinet_number")
    private int cabinetNumber;

    @Override
    public <T> T accept(EmployeeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(int cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }
}