package database.app_database.Model.Employee.AccessWorker;

import database.app_database.Dao.Roles;

import javax.persistence.*;

@Entity
@Table(name = "vet")
@PrimaryKeyJoinColumn(name = "access_worker_id")
public class Vet extends AccessWorker {

    private final static Roles role = Roles.vet;

    @Column(name = "laboratory_number")
    private int laboratoryNumber;

    @Override
    public <T> T accept(EmployeeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public Roles getRole() {
        return role;
    }

    public int getLaboratoryNumber() {
        return laboratoryNumber;
    }

    public void setLaboratoryNumber(int laboratoryNumber) {
        this.laboratoryNumber = laboratoryNumber;
    }
}