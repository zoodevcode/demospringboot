package securitySpringBoot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import securitySpringBoot.demo.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
