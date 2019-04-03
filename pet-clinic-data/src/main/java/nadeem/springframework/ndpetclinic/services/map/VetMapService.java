package nadeem.springframework.ndpetclinic.services.map;

import nadeem.springframework.ndpetclinic.model.Speciality;
import nadeem.springframework.ndpetclinic.model.Vet;
import nadeem.springframework.ndpetclinic.services.SpecialitiesService;
import nadeem.springframework.ndpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    private  final SpecialitiesService specialitiesService;

    public VetMapService(SpecialitiesService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size()>0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId()==null){
                    Speciality savedSpeciality=specialitiesService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save( object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}