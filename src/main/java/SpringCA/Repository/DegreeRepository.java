package SpringCA.Repository;

import SpringCA.entities.Degree;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepository extends CrudRepository<Degree, Integer> {
}
