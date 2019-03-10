package nadeem.springframework.ndpetclinic.services;

import nadeem.springframework.ndpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
