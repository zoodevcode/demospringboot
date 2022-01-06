package securitySpringBoot.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import securitySpringBoot.demo.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Page<Product> findByNameContains(String mc, Pageable pageable);
}
