package nadeem.springframework.ndpetclinic.services.map;

import nadeem.springframework.ndpetclinic.model.Owner;
import nadeem.springframework.ndpetclinic.model.Pet;
import nadeem.springframework.ndpetclinic.services.OwnerService;
import nadeem.springframework.ndpetclinic.services.PetService;
import nadeem.springframework.ndpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    private  final PetTypeService petTypeService;
    private  final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object!=null){
            if(object.getPets()!=null){
                object.getPets().forEach(pet -> {
                  if(pet.getPetType()!=null){
                        if(pet.getPetType().getId() ==null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                  }else{
                      throw new RuntimeException("Pet Tyep is Requaired");
                  }
                  if(pet.getId()==null){
                      Pet savedPet=petService.save(pet);
                      pet.setId(savedPet.getId());
                  }
                });
            }
            return super.save(object);
        }else{
            return null;
        }

    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
