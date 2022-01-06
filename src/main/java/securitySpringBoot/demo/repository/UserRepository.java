package securitySpringBoot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import securitySpringBoot.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   public User findByUsername(String username);
}
