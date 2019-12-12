package SpringCA.Repository;

import SpringCA.entities.StudentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentUserRepository extends JpaRepository<StudentUser, Integer> {
    StudentUser findByUserId_Username(String username);

    StudentUser findByUserId_User(int studentId);
}
