package nadeem.springframework.ndpetclinic.repositories;

import nadeem.springframework.ndpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
