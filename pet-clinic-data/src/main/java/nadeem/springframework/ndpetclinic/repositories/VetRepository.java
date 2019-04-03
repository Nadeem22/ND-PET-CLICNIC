package nadeem.springframework.ndpetclinic.repositories;

import nadeem.springframework.ndpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
