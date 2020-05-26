package database.app_database.Model.Employee.AccessWorker;

import database.app_database.Dao.Roles;

import javax.persistence.*;

@Entity
@Table(name = "cleaner")
@PrimaryKeyJoinColumn(name = "access_worker_id")
public class Cleaner extends AccessWorker {
    private final static Roles role = Roles.cleaner;

    @Column(name = "pantry_number")
    private int pantryNumber;

    @Override
    public <T> T accept(EmployeeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Roles getRole() {
        return role;
    }

    public int getPantryNumber() {
        return pantryNumber;
    }

    public void setPantryNumber(int pantryNumber) {
        this.pantryNumber = pantryNumber;
    }
}