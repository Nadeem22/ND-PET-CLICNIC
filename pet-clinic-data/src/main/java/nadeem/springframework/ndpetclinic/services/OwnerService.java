package nadeem.springframework.ndpetclinic.services;

import nadeem.springframework.ndpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

  /* Owner findById(long id);

   Owner save(Owner owner);

   Set<Owner> findAll();*/
}
