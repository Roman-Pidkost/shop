package roman.pidkostelnyi.demo.dto.response;

import lombok.Getter;
import lombok.Setter;
import roman.pidkostelnyi.demo.entity.Category;

@Setter
@Getter
public class CategoryResponse {
    private String name;
    private Long id;

    public CategoryResponse(Category category) {
        name = category.getName();
        id = category.getId();
    }
}
