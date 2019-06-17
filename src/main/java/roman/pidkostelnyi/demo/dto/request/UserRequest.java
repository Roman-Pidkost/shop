package roman.pidkostelnyi.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRequest {
    private String username;
    private String password;
    private List<Long> favoritesIds;
}
