package roman.pidkostelnyi.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductCriteria {
    private String name;
    private Long minPrice;
    private Long maxPrice;
    private Long categoryId;

    @NotNull
    private PaginationRequest paginationRequest;
}
