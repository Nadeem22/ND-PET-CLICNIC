package nadeem.springframework.ndpetclinic.services;

import nadeem.springframework.ndpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(long id);

  Vet save(Vet vet);

    Set<Vet> findAll();
}
