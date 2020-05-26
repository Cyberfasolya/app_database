package database.app_database.Model.Employee.AccessWorker;

import database.app_database.Dao.Roles;

import javax.persistence.*;

@Entity
@Table(name = "trainer")
@PrimaryKeyJoinColumn(name = "access_worker_id")
public class Trainer extends AccessWorker {
    private final static Roles role = Roles.trainer;

    @Column(name = "hall_number")
    private int hallNumber;

    @Override
    public <T> T accept(EmployeeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Roles getRole() {
        return role;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }
}