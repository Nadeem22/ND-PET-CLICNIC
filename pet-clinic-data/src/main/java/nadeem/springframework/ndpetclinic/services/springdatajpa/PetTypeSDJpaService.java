package nadeem.springframework.ndpetclinic.services.springdatajpa;


import nadeem.springframework.ndpetclinic.model.PetType;
import nadeem.springframework.ndpetclinic.repositories.PetTypeRepository;
import nadeem.springframework.ndpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final  PetTypeRepository peTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository peTypeRepository) {
        this.peTypeRepository = peTypeRepository;
    }


    @Override
    public Set<PetType> findAll() {
       Set<PetType> petTypes=new HashSet<>();
       peTypeRepository.findAll().forEach(petTypes::add);
       return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return peTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return peTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        peTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        peTypeRepository.deleteById(aLong);
    }


}
