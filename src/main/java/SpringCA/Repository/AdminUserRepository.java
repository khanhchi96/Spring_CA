package SpringCA.Repository;

import SpringCA.entities.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Integer> {
    AdminUser findByUserId_Username(String username);
}
