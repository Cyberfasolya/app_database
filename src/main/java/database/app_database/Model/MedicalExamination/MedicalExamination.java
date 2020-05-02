package database.app_database.Model.MedicalExamination;

import database.app_database.Model.Animal.Animal;
import database.app_database.Model.Employee.AccessWorker.Vet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medical_examination")
public class MedicalExamination {
    @Id
    private int id;

    @Column(name = "weight")
    private int weight;

    @Column(name = "height")
    private int height;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "illness_on_medical_examination", joinColumns = @JoinColumn(name = "medical_examination_id"), inverseJoinColumns = @JoinColumn(name = "illness_id"))
    private List<Illness> illnesses = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vet_id")
    private Vet vet;
}

