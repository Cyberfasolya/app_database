package database.app_database.Model.Employee.AccessWorker;

import javax.persistence.*;

@Entity
@Table(name = "vet")
@PrimaryKeyJoinColumn(name = "access_worker_id")
public class Vet extends AccessWorker {
    @Column(name = "laboratory_number")
    private int laboratoryNumber;

    @Override
    public <T> T accept(EmployeeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int getLaboratoryNumber() {
        return laboratoryNumber;
    }

    public void setLaboratoryNumber(int laboratoryNumber) {
        this.laboratoryNumber = laboratoryNumber;
    }
}