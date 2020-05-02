package database.app_database.Model.Animal;

import database.app_database.Model.BaseObject;
import database.app_database.Model.Employee.AccessWorker.Access;
import database.app_database.Model.Exchange.Exchange;
import database.app_database.Model.MedicalExamination.MedicalExamination;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "animal")
public class Animal extends BaseObject {
    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cage_id")
    private Cage cage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "species_id")
    private Species species;

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MedicalExamination> medicalExaminations= new ArrayList<>();

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Exchange> exchangeList = new ArrayList<>();

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Access> accessList = new ArrayList<>();

    @Column(name = " date_of_birth", nullable = false)
    private Instant date_of_birth;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "name")
    private String name;

    @Column(name = "physical_state", nullable =  false)
    private boolean physical_state;

    @Column(name = "hospital")
    private boolean hospital;

    @Column(name = "reciept_date", nullable =  false)
    private Instant reciept_date;

    @Column(name = "number_of_offspring")
    private int number_of_offspring;

    @Override
    public Integer getId() {
        return id;
    }
}




