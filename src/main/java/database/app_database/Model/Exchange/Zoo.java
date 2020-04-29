package database.app_database.Model.Exchange;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zoo")
public class Zoo {
    @Id
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "zoo", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Exchange> exchangeList = new ArrayList<>();
}
