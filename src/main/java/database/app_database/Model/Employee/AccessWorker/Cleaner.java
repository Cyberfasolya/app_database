package database.app_database.Model.Employee.AccessWorker;
import javax.persistence.*;

@Entity
@Table(name = "cleaner")
@PrimaryKeyJoinColumn(name = "access_worker_id")
public class Cleaner extends AccessWorker {
    @Column(name = "pantry_number")
    private int pantryNumber;

    @Override
    public <T> T accept(EmployeeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public int getPantryNumber() {
        return pantryNumber;
    }

    public void setPantryNumber(int pantryNumber) {
        this.pantryNumber = pantryNumber;
    }
}