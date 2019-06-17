package roman.pidkostelnyi.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private Long price;
    private String description;
    private Long categoryId;
}
