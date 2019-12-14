package SpringCA.Repository;

import SpringCA.entities.PasswordResetTokenStudent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenStudentRepository extends CrudRepository<PasswordResetTokenStudent, Integer> {
    Iterable<PasswordResetTokenStudent> findByStudentUser_Username(String studentUsername);
}
