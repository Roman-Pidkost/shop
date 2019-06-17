package roman.pidkostelnyi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roman.pidkostelnyi.demo.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
