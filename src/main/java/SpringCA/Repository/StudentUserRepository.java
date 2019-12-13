package SpringCA.Repository;

import SpringCA.entities.StudentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentUserRepository extends JpaRepository<StudentUser, Integer> {
    StudentUser findByUsername(String username);

    StudentUser findByStudentUser_StudentId(int studentId);
}
