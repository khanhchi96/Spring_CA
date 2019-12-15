package SpringCA.Repository;

import SpringCA.entities.CompositeId.LecturerLeaveId;
import SpringCA.entities.LecturerLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerLeaveRepository extends JpaRepository<LecturerLeave, LecturerLeaveId> {
    Iterable<LecturerLeave> findByLecturerByLeave_LecturerIdAndStatus(int lecturerId, String leave);
}
