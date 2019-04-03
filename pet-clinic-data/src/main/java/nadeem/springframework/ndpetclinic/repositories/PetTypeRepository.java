package nadeem.springframework.ndpetclinic.repositories;

import nadeem.springframework.ndpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
