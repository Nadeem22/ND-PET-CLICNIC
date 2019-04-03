package nadeem.springframework.ndpetclinic.repositories;

import nadeem.springframework.ndpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long>{
     Owner findByLastName(String lastName);
}
