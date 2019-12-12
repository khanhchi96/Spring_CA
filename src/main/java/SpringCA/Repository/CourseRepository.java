package SpringCA.Repository;

import SpringCA.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByCourseId(int id);
}
