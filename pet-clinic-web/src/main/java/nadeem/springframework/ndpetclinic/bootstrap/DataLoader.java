package nadeem.springframework.ndpetclinic.bootstrap;

import nadeem.springframework.ndpetclinic.model.Owner;
import nadeem.springframework.ndpetclinic.model.PetType;
import nadeem.springframework.ndpetclinic.model.Vet;
import nadeem.springframework.ndpetclinic.services.OwnerService;
import nadeem.springframework.ndpetclinic.services.PetTypeService;
import nadeem.springframework.ndpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private  final VetService vetService;
    private final PetTypeService petTypeService;




    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }



    @Override
    public void run(String... args) throws Exception {

        PetType dog=new PetType();
        dog.setName("Dog");
        PetType saveDogPetType=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("Cat");
        PetType saveCatPetType=petTypeService.save(cat);


        Owner owner1=new Owner();

        owner1.setFirstName("Nadeem");
        owner1.setLastName("siddiqui");
        ownerService.save(owner1);

        Owner owner2=new Owner();

        owner2.setFirstName("Mohammad");
        owner2.setLastName("sharique");
        ownerService.save(owner2);

        System.out.println("Owner Loaded");

        Vet vet1=new Vet();

        vet1.setFirstName("pradeep");
        vet1.setLastName("Soma");
        vetService.save(vet1);

        Vet vet2=new Vet();

        vet2.setFirstName("Avinash");
        vet2.setLastName("Kumar");
        vetService.save(vet2);

        System.out.println("Vet is Loaded");

    }
}
