package SpringCA.Repository;

import SpringCA.entities.CompositeId.LecturerLeaveId;
import SpringCA.entities.LecturerLeave;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturerLeaveRepository extends JpaRepository<LecturerLeave, LecturerLeaveId> {
    Iterable<LecturerLeave> findByLecturerByLeave_LecturerIdAndStatus(int lecturerId, String leave);

    Page<LecturerLeave> findByStatus(String status, Pageable pageable);

    List<LecturerLeave> findByStatus(String status);
}
