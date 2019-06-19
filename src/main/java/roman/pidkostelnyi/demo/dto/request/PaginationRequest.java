package roman.pidkostelnyi.demo.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import roman.pidkostelnyi.demo.dto.response.PageResponse;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PaginationRequest {
    @NotNull
    private Integer page;
    @NotNull
    private Integer size;
    private Sort.Direction direction;
    private String field;

    public Pageable toPageable() {
        if (direction != null && field != null) {
            return PageRequest.of(page, size, direction, field);
        } else if (direction != null) {
            return PageRequest.of(page, size, direction, "id");
        } else if (field != null) {
            return PageRequest.of(page, size, Sort.Direction.ASC, field);
        } else {
            return PageRequest.of(page, size);
        }
    }
}
