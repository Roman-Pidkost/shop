package roman.pidkostelnyi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roman.pidkostelnyi.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
}
