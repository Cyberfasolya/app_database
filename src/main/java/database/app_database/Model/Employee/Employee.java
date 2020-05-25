package database.app_database.Model.Employee;

import database.app_database.Model.Employee.AccessWorker.Cleaner;
import database.app_database.Model.Employee.AccessWorker.Trainer;
import database.app_database.Model.Employee.AccessWorker.Vet;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {
    @Id
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "work_start_date", nullable = false)
    private Instant workStartDate;

    @Column(name = "monthly_salary", nullable = false)
    private int monthlySalary;

    @Column(name = "gender", nullable = false)
    private String gender;

    public interface EmployeeVisitor<T> {
        T visit(BuilderWorker builderWorker);

        T visit(Administrator administrator);

        T visit(Cleaner cleaner);

        T visit(Trainer trainer);

        T visit(Vet vet);
    }

    public abstract <T> T accept(EmployeeVisitor<T> visitor);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Instant getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(Instant work_start_date) {
        this.workStartDate = work_start_date;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}



