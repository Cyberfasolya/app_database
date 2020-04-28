package database.app_database.Model.Exchange;
import javax.persistence.*;

@Entity
@Table(name = "zoo")
public class Zoo {
    @Id
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
