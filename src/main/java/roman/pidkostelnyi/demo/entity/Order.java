package roman.pidkostelnyi.demo.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "_Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private LocalTime time;

    private Boolean finished;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order")
    private List<ProductCount> productCounts = new ArrayList<>();

    public Order() {
    }
}
