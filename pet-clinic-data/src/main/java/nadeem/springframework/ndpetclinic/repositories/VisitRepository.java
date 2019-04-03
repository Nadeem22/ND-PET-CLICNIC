package nadeem.springframework.ndpetclinic.repositories;

import nadeem.springframework.ndpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
