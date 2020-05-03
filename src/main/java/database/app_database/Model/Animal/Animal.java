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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cage_id")
//    private Cage cage;

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
    private Instant dateOfBirth;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "name")
    private String name;

    @Column(name = "physical_state", nullable =  false)
    private boolean physicalState;

    @Column(name = "hospital")
    private boolean hospital;

    @Column(name = "reciept_date", nullable =  false)
    private Instant receiptDate;

    @Column(name = "number_of_offspring")
    private int numberOfOffspring;

    @Column(name = "cage_id")
    private int cage;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public List<MedicalExamination> getMedicalExaminations() {
        return medicalExaminations;
    }

    public void setMedicalExaminations(List<MedicalExamination> medicalExaminations) {
        this.medicalExaminations = medicalExaminations;
    }

    public List<Exchange> getExchangeList() {
        return exchangeList;
    }

    public void setExchangeList(List<Exchange> exchangeList) {
        this.exchangeList = exchangeList;
    }

    public List<Access> getAccessList() {
        return accessList;
    }

    public void setAccessList(List<Access> accessList) {
        this.accessList = accessList;
    }

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Instant dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPhysicalState() {
        return physicalState;
    }

    public void setPhysicalState(boolean physicalState) {
        this.physicalState = physicalState;
    }

    public boolean isHospital() {
        return hospital;
    }

    public void setHospital(boolean hospital) {
        this.hospital = hospital;
    }

    public Instant getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Instant receiptDate) {
        this.receiptDate = receiptDate;
    }

    public int getNumberOfOffspring() {
        return numberOfOffspring;
    }

    public void setNumberOfOffspring(int numberOfOffspring) {
        this.numberOfOffspring = numberOfOffspring;
    }

    public int getCage() {
        return cage;
    }

    public void setCage(int cage) {
        this.cage = cage;
    }
}




