package database.app_database.Model.Feed;
import javax.persistence.*;

@Entity
@Table(name = "provider")
public class Provider {
    @Id
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
