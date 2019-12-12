package SpringCA.Repository;

import SpringCA.entities.LecturerCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LecturerCourseRepository extends JpaRepository<LecturerCourse, Integer> {
    Iterable<LecturerCourse> findByCourseByLecturer_CourseId(int courseId);

    Iterable<LecturerCourse> findByCourseByLecturer_CourseIdAndSemesterLecturerCourse_SemesterId(int courseId, int SemesterId);

    Set<LecturerCourse> findByLecturerByCourse_LecturerId(int lecturerId);
}
