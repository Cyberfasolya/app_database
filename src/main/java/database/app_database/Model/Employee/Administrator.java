package database.app_database.Model.Employee;

import database.app_database.Dao.Roles;

import javax.persistence.*;

@Entity
@Table(name = "administration_worker")
@PrimaryKeyJoinColumn(name = "employee_id")
public class Administrator extends Employee {
    private final static Roles role = Roles.administrator;

    @Column(name = "cabinet_number")
    private int cabinetNumber;

    @Override
    public <T> T accept(EmployeeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Roles getRole() {
        return role;
    }

    public int getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(int cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }
}