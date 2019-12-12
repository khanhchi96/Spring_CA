package SpringCA.Repository;

import SpringCA.entities.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
    Iterable<StudentCourse> findByCourseByStudent_CourseId(int courseId);

    Iterable<StudentCourse> findByCourseByStudent_CourseIdAndSemesterStudentCourse_SemesterIdAndStatus(int courseId, int semesterId, String status);

    Iterable<StudentCourse> findByStudentByCourse_StudentId(int studentId);
}
