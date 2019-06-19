package roman.pidkostelnyi.demo.dto.response;

import lombok.Getter;
import lombok.Setter;
import roman.pidkostelnyi.demo.entity.Category;
import roman.pidkostelnyi.demo.entity.Product;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private Long price;
    private String description;

    public ProductResponse(Product product) {
        id = product.getId();
        price = product.getPrice();
        name = product.getName();
        description = product.getDescription();
    }

}
