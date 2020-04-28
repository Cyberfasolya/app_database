package database.app_database.Model.MedicalExamination;
import javax.persistence.*;

@Entity
@Table(name = "illness")
public class Illness {
    @Id
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "graft")
    private String graft;
}
