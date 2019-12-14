package SpringCA.Repository;

import SpringCA.entities.PasswordResetTokenAdmin;
import SpringCA.entities.PasswordResetTokenStudent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenAdminRepository extends CrudRepository<PasswordResetTokenAdmin, Integer> {
    Iterable<PasswordResetTokenAdmin> findByAdminUser_Username(String adminUsername);
}
