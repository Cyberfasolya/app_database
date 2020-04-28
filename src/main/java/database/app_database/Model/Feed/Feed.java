package database.app_database.Model.Feed;
import javax.persistence.*;

@Entity
@Table(name = "feed")
public class Feed {
    @Id
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;
}

