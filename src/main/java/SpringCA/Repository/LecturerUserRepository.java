package SpringCA.Repository;

import SpringCA.entities.LecturerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerUserRepository extends JpaRepository<LecturerUser, Integer> {
    LecturerUser findByUsername(String username);

    LecturerUser findByLecturerUser_LecturerId(int lecturerId);

}
