package roman.pidkostelnyi.demo.entity;


import javax.persistence.*;

@Entity
public class ProductCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Order order;

    public ProductCount() {
    }
}
