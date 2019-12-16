package SpringCA.Repository;

import SpringCA.entities.PasswordResetTokenLecturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenLecturerRepository extends CrudRepository<PasswordResetTokenLecturer, Integer> {
    Iterable<PasswordResetTokenLecturer> findByLecturerUser_Username(String lecturerUsername);
}
