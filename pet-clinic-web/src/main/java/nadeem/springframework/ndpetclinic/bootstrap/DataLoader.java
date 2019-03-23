package nadeem.springframework.ndpetclinic.bootstrap;

import nadeem.springframework.ndpetclinic.model.*;
import nadeem.springframework.ndpetclinic.services.OwnerService;
import nadeem.springframework.ndpetclinic.services.PetTypeService;
import nadeem.springframework.ndpetclinic.services.SpecialitiesService;
import nadeem.springframework.ndpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private  final VetService vetService;
    private final PetTypeService petTypeService;
    private  final SpecialitiesService specialitiesService;




    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }



    @Override
    public void run(String... args) throws Exception {
        int count=petTypeService.findAll().size();

      if(count==0) {
          loadData();
      }
    }

    private void loadData() {
        PetType dog=new PetType();
        dog.setName("Dog");
        PetType saveDogPetType=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("Cat");
        PetType saveCatPetType=petTypeService.save(cat);


        Speciality radiology=new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology=specialitiesService.save(radiology);


        Speciality surgery=new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery=specialitiesService.save(surgery);

        Speciality dentistry=new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry=specialitiesService.save(dentistry);


        Owner owner1=new Owner();

        owner1.setFirstName("Nadeem");
        owner1.setLastName("siddiqui");
        owner1.setAddress("#123 Bakhshipura");
        owner1.setCity("Bahraich");
        owner1.setTelephone("7007416236");
        ownerService.save(owner1);

        Owner owner2=new Owner();

        owner2.setFirstName("Mohammad");
        owner2.setLastName("sharique");
        owner2.setAddress("#321 Khadra");
        owner2.setCity("Lucknow");
        owner2.setTelephone("7019342934");
        ownerService.save(owner2);

        System.out.println("Owner Loaded");

        Pet shariquePet=new Pet();
        shariquePet.setPetType(saveDogPetType);
        shariquePet.setOwner(owner2);
        shariquePet.setBirthDate(LocalDate.now());
        shariquePet.setName("Buldozer");
        owner2.getPets().add(shariquePet);

        Pet nadeemPet =new Pet();
        nadeemPet.setPetType(saveCatPetType);
        nadeemPet.setName("TimTim");
        nadeemPet.setBirthDate(LocalDate.now());
        nadeemPet.setOwner(owner1);
        owner1.getPets().add(nadeemPet);

        Vet vet1=new Vet();

        vet1.setFirstName("pradeep");
        vet1.setLastName("Soma");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2=new Vet();

        vet2.setFirstName("Avinash");
        vet2.setLastName("Kumar");
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Vet is Loaded");
    }
}
