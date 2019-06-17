package roman.pidkostelnyi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roman.pidkostelnyi.demo.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
