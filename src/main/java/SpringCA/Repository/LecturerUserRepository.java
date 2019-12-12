package SpringCA.Repository;

import SpringCA.entities.LecturerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerUserRepository extends JpaRepository<LecturerUser, Integer> {
    LecturerUser findByUserId_Username(String username);

    LecturerUser findByUserId_User(int lecturerId);
}
