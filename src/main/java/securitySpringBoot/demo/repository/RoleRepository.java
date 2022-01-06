package securitySpringBoot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import securitySpringBoot.demo.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
