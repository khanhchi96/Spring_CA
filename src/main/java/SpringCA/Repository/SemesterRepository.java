package SpringCA.Repository;

import SpringCA.entities.Semester;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends CrudRepository<Semester, Integer> {
}
