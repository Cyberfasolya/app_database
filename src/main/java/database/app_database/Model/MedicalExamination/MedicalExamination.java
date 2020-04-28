package database.app_database.Model.MedicalExamination;

import database.app_database.Model.Animal.Animal;
import database.app_database.Model.Employee.AccessWorker.Vet;

import javax.persistence.*;

@Entity
@Table(name = "medical_examination")
public class MedicalExamination {
    @Id
    private int id;

    @Column(name = "weight")
    private int weight;

    @Column(name = "height")
    private int height;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vet_id")
    private Vet vet;
}

